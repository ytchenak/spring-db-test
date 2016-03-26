package my.groupid.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import my.groupid.config.MyAppRootConfig;
import my.groupid.config.MyWebMvcConfig;

// replace web.xml to code-based configuration
//http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-container-config
//
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { MyAppRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MyWebMvcConfig.class
        , SwaggerConfig.class 
        };
    }

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// @Override
	// public void onStartup(ServletContext servletContext) throws ServletException {
	// 	super.onStartup(servletContext);
	// 	servletContext.setInitParameter("spring.profiles.active", "hsql");
	// }

}