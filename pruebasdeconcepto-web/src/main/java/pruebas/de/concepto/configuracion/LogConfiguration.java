package pruebas.de.concepto.configuracion;

import java.io.File;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

@Component
public class LogConfiguration {
	private static final Logger log = LoggerFactory.getLogger(LogConfiguration.class);
 
	private static final String APPS_CONFIG_PATH = "apps_config_path";
	private final static String LOGGING_CONFIGURATION = "logback-";
	private static final String APPS_ENV = "apps_env";
	private static final String APP_NAME = "app_name";

	@PostConstruct
	public void configureLogBack() {

		log.info("Configuring logback with external file");

		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		File fileLog = null;
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(loggerContext);
			loggerContext.reset();
			StringBuilder sb = new StringBuilder();
			fileLog = new File(sb.append(System.getProperty(APPS_CONFIG_PATH)).append(File.separator).append(System.getProperty(APP_NAME)).append(File.separator)
					.append(LOGGING_CONFIGURATION).append(System.getProperty(APPS_ENV)).append(".xml").toString());
			configurator.doConfigure(fileLog);
		} catch (JoranException je) {
			log.error("Error cargando fichero de logback ", je);
		}
		log.info("Fichero de configuracion de log cargado {} ", fileLog.getAbsolutePath());

		StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);

		log.info("LogBack reStarted");

	}
}
