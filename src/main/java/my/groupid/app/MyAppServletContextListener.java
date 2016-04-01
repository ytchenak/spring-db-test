package my.groupid.app;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MyAppServletContextListener implements ServletContextListener{
	
	
	private final Logger logger = LoggerFactory.getLogger(MyAppServletContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("+++++++++++++++++ServletContextListener destroyed");
	}
    
	//Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		logger.info("+++++++++++++++++++++ServletContextListener started");	
	}
}