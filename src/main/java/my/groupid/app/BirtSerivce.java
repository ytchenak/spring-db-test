package my.groupid.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BirtSerivce 
{
	private final Logger logger = LoggerFactory.getLogger(BirtSerivce.class);

	@Autowired
	DataSource dataSource;

	@PostConstruct
	public void afterPropertiesSet() {
		logger.info("++++++++++++++++++++++++++++start {} ++++++++++++++++", this.dataSource);
	}

	@PreDestroy
	public void destroy()  {
		logger.info("++++++++++++++++++++++++++++destroy {} ++++++++++++++++");
	}
	
	
}