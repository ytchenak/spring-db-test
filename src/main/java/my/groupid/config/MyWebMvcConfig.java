package my.groupid.config;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-config
//http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-config-customize

@Configuration
@EnableWebMvc
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }
 
 
}