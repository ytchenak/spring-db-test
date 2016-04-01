package my.groupid.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DbPopulater {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void populate() {
		jdbcTemplate.update("drop table if exists reports");
		jdbcTemplate.update("create table reports (id varchar(36), category_id int, name varchar(256))");
		jdbcTemplate.update("insert into reports values ('1',1, 'aaaaaa')");
		jdbcTemplate.update("insert into reports values ('2',1, 'bbbbbb')");
		jdbcTemplate.update("insert into reports values ('3',1, 'cccccc')");
	}
	
}
