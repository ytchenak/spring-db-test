package my.groupid.app;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.data.oda.jdbc.IConnectionFactory;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.birt.report.model.api.IDesignEngineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirtSerivce {
	private final Logger logger = LoggerFactory.getLogger(BirtSerivce.class);

	@Autowired
	DataSource dataSource;

	private IDesignEngine designEngine;

	private IReportEngine reportEngine;

	@PostConstruct
	public void init() throws SQLException {
		logger.info("++++++++++++++++++++++++++++BIRT init ++++++++++++++++");

		try {
			EngineConfig engineConfig = new EngineConfig();
			DesignConfig designConfig = new DesignConfig();
			Platform.startup(engineConfig);
			IReportEngineFactory reportEngineFactory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			IDesignEngineFactory designEngineFactory = (IDesignEngineFactory) Platform
					.createFactoryObject(IDesignEngineFactory.EXTENSION_DESIGN_ENGINE_FACTORY);

			logger.debug("creating birt design engine");

			setDesignEngine(designEngineFactory.createDesignEngine(designConfig));

			logger.debug("creating birt report engine");
			IReportEngine newReportEngine = reportEngineFactory.createReportEngine(engineConfig);
			@SuppressWarnings("unchecked")
			HashMap<String, Object> appContext = newReportEngine.getConfig().getAppContext();
			appContext.put(IConnectionFactory.PASS_IN_CONNECTION, dataSource.getConnection());
			appContext.put(IConnectionFactory.CLOSE_PASS_IN_CONNECTION, false);
			setReportEngine(newReportEngine);

			logger.info("contextInitialized is finished");
		} catch (BirtException e) {

			logger.error(e.getMessage());
		}
	}

	@PreDestroy
	public void destroy() {
		logger.info("++++++++++++++++++++++++++++destroy {} ++++++++++++++++");
	}

	public IDesignEngine getDesignEngine() {
		return designEngine;
	}

	private void setDesignEngine(IDesignEngine designEngine) {
		this.designEngine = designEngine;
	}

	public IReportEngine getReportEngine() {
		return reportEngine;
	}

	private void setReportEngine(IReportEngine reportEngine) {
		this.reportEngine = reportEngine;
	}

	public String generateHtml(String reportName) throws EngineException, UnsupportedEncodingException {
		logger.info("reportName: {}", reportName);

		// Open report design
		IReportRunnable design = this.reportEngine.openReportDesign(reportName);

		// create task to run and render report
		IRunAndRenderTask task = this.reportEngine.createRunAndRenderTask(design);

		// set output options
		HTMLRenderOption options = new HTMLRenderOption();
		options.setOutputFormat(IRenderOption.OUTPUT_FORMAT_HTML);

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		options.setOutputStream(bout);
		options.setEnableInlineStyle(true);
		task.setRenderOption(options);

		// run report
		task.run();
		task.close();

		String reportOutput = bout.toString("UTF-8");

		return reportOutput;

	}

}