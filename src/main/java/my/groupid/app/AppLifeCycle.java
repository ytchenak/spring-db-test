package my.groupid.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// managing application life cycle (construct and destroy)
// java annotation is used instead spring's interface InitializingBean, DisposableBean 

@Component
public class AppLifeCycle 
{
	private final Logger logger = LoggerFactory.getLogger(AppLifeCycle.class);

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