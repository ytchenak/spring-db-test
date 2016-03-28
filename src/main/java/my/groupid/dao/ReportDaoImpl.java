package my.groupid.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import my.groupid.api.ReportDTO;

@Repository
public class ReportDaoImpl implements ReportDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(DataSource datasource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	public List<ReportDTO> findByCategoryId(String categoryId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        
		String sql = "SELECT * FROM reports WHERE category_id=:categoryId";
		
        List<ReportDTO> results = namedParameterJdbcTemplate.query(
                    sql,
                    params,
                    new ReportMapper());
        
        return results;
        
	}

	public List<ReportDTO> findAll() {
		
		String sql = "SELECT * FROM reports";
		
        List<ReportDTO> result = namedParameterJdbcTemplate.query(sql, new ReportMapper());
        
        return result;
        
	}

	private static final class ReportMapper implements RowMapper<ReportDTO> {

		public ReportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReportDTO report = new ReportDTO();
			report.setReportId(rs.getString("report_id"));
			report.setCategoryId(rs.getString("category_id"));
			report.setReportName(rs.getString("report_name"));
			return report;
		}
	}

}