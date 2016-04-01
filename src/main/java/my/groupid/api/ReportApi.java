package my.groupid.api;
 
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import my.groupid.app.DbConnector;
import my.groupid.dao.DbPopulater;
import my.groupid.dao.ReportDao;

@RestController
@RequestMapping(value = "/report")
public class ReportApi {
    
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportApi.class);
	
	@Autowired
	public ReportDao reportDao;

	@Autowired
	public DbConnector dbConnector; 
	
	@Autowired
	public DbPopulater dbPopulater;
	
	@ApiOperation(value = "Getting Reports per Categories", notes = "", response = ReportDTO.class ,responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Operation"), 			
			@ApiResponse(code = 500, message = "Internal Server Error") })
	
	  @RequestMapping(value = "/getReportsByCategory", produces =  { APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	  public @ResponseBody ResponseEntity<List<ReportDTO>>  getReportsByCategory(
			  @ApiParam(value = "Category Id") @RequestParam(value="category-id" , required=true) int categoryId) throws EmApiException{

			LOGGER.info("getting repors by category {}", categoryId);
			
			dbConnector.initialize();
			dbPopulater.populate();
			
            List<ReportDTO> reports = this.reportDao.findByCategoryId(categoryId);

			return new ResponseEntity<List<ReportDTO>>(reports,HttpStatus.OK);
	  }
}
