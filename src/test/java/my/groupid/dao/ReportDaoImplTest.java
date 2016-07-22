package my.groupid.dao;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import my.groupid.api.ReportDTO;

public class ReportDaoImplTest {
    private EmbeddedDatabase db;

	@Before
	public void setUp() throws Exception {
    	db = new EmbeddedDatabaseBuilder()
        		.setType(EmbeddedDatabaseType.HSQL)
        		.addScript("db/sql/create-db.sql")
        		.addScript("db/sql/insert-data.sql")
        		.build();
	}

//	@Test
//	public void testSetDataSource() {
//		ReportDaoImpl target = new ReportDaoImpl();
//		DataSource dataSource = new SingleConnectionDataSource();
//		target.setDataSource(dataSource);
//		assertNotNull(target.);
//	}


	@Test
	public void testFindByCategoryId() {
		ReportDaoImpl target = new ReportDaoImpl();
		target.setDataSource(db);
		List<ReportDTO> results = target.findByCategoryId(1);
		assertEquals(2, results.size());
	}

	@Test
	public void testFindAll() {
		ReportDaoImpl target = new ReportDaoImpl();
		target.setDataSource(db);
		List<ReportDTO> results = target.findAll();
		assertEquals(3, results.size());
	}

}
