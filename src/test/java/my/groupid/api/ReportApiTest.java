package my.groupid.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import my.groupid.app.DbConnector;
import my.groupid.dao.DbPopulater;
import my.groupid.dao.ReportDao;
import my.groupid.dao.ReportDaoImpl;

import static org.mockito.Mockito.*;

import java.util.List;

public class ReportApiTest {

	private ReportApi target;
	private EmbeddedDatabase db;

	@Before
	public void setUp() throws Exception {
		
    	db = new EmbeddedDatabaseBuilder()
        		.setType(EmbeddedDatabaseType.HSQL)
        		.addScript("db/sql/create-db.sql")
        		.addScript("db/sql/insert-data.sql")
        		.build();
		
		target = new ReportApi();
		target.dbConnector = mock(DbConnector.class);
		target.dbPopulater = mock(DbPopulater.class);
		ReportDaoImpl dao = new ReportDaoImpl();
		dao.setDataSource(db);
		target.reportDao = dao;

	}

	@Test
	public void testGetReportsByCategory() throws EmApiException {
		ResponseEntity<List<ReportDTO>> result = target.getReportsByCategory(1);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(2, result.getBody().size());
	}

}
