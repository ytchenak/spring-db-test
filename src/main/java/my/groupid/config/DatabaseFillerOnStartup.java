package my.groupid.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseFillerOnStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	DataSource dataSource;
	
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.execute(action)
    }
}