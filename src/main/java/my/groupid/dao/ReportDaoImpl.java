package my.groupid.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import my.groupid.api.ReportDTO;

@Repository
public class ReportDaoImpl implements ReportDao {
	
	private final Logger logger = LoggerFactory.getLogger(ReportDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<ReportDTO> findByCategoryId(String categoryId) {
		logger.info("+++ find catefory by {}", categoryId);
		
        
		String sql = "SELECT * FROM reports WHERE category_id=" + categoryId;
		
        List<ReportDTO> results = jdbcTemplate.query(
                    sql,
                    new ReportMapper());
        
        return results;
        
	}

	public List<ReportDTO> findAll() {
		
		String sql = "SELECT * FROM reports";
		
        List<ReportDTO> result = jdbcTemplate.query(sql, new ReportMapper());
        
        return result;
        
	}

	private static final class ReportMapper implements RowMapper<ReportDTO> {

		public ReportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReportDTO report = new ReportDTO();
			report.setReportId(rs.getString("id"));
			report.setCategoryId(rs.getString("category_id"));
			report.setReportName(rs.getString("name"));
			return report;
		}
	}

}