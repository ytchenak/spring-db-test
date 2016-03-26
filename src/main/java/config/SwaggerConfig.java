package my.groupid.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@ComponentScan(basePackages = "my.groupid.api")
@EnableWebMvc
@EnableSwagger2 //Loads the spring beans required by the framework
@PropertySource("classpath:swagger.properties")
@Import(SwaggerUiConfiguration.class)
public class SwaggerConfig {
    @Bean
    ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
        "RF Api Documentation",
        "RF Api Documentation",
        "1.0",
        "",
        "www.bmc.com",
        "BMC License",
        "http://www.bmc.com/support/licensing-passwords/support-licensing-passwords.html" );
        return apiInfo;
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.protocols(new HashSet<String>(Arrays.asList("http")))
        		.useDefaultResponseMessages(false); //https://github.com/springfox/springfox/issues/632
    }

}