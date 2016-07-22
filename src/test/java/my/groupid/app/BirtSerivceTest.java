package my.groupid.app;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.eclipse.birt.report.engine.api.EngineException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class BirtSerivceTest {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(BirtSerivceTest.class);
	
	private EmbeddedDatabase db;
	private BirtSerivce birt;

	@Before
	public void setUp() throws Exception {
    	db = new EmbeddedDatabaseBuilder()
        		.setType(EmbeddedDatabaseType.HSQL)
        		.addScript("db/sql/create-db.sql")
        		.addScript("db/sql/insert-data.sql")
        		.build();

		birt = new BirtSerivce();
		birt.dataSource = db;
		birt.init();
	}

	// @Test
	public void testGenerateHtml() throws EngineException, UnsupportedEncodingException {
		String reportName = "c:/work/spring-db-test/reports/alerts.rptdesign";
		String out = birt.generateHtml(reportName);
		LOGGER.info(out);
	}

}
