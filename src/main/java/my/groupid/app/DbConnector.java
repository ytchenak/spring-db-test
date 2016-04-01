package my.groupid.app;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DbConnector 
{
	private final Logger logger = LoggerFactory.getLogger(DbConnector.class);

	@Autowired
	volatile DataSource dataSource;

	public void initialize() {
		org.apache.tomcat.jdbc.pool.DataSource ds = (org.apache.tomcat.jdbc.pool.DataSource)dataSource;
		if( ds.getDataSource() != null)
			return;
		
        logger.info("initilize data source");
		synchronized (dataSource) {
	        ds.setDriverClassName("org.hsqldb.jdbcDriver");
	        ds.setUrl("jdbc:hsqldb:mem:gcsdb");
		}
	
	}
	
	
}