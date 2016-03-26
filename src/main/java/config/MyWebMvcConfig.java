package my.groupid.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-config
//http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-config-customize

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "my.groupid.api" )
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }
 
 
}