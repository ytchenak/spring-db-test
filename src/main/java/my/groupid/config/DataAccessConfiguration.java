package my.groupid.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://blog.zenika.com/2013/01/30/using-tomcat-jdbc-connection-pool-in-a-standalone-environment/

@Configuration
public class DataAccessConfiguration {
 
    @Bean(destroyMethod = "close")
    public javax.sql.DataSource datasource() {
    	
        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        
        //TOOD: in real server will be set latter 

//        ds.setDriverClassName("org.hsqldb.jdbcDriver");
//        ds.setUrl("jdbc:hsqldb:mem:gcsdb");

//        ds.setDriverClassName("org.sqlite.JDBC");
//        ds.setUrl("jdbc:sqlite:stats.db");

        ds.setUsername("sa");
        ds.setPassword("");

        
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        ds.setMaxIdle(5);
        ds.setMinIdle(2);
        return ds;
    }
 
 
}