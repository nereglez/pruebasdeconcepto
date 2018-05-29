package pruebas.de.concepto.configuracion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


@Configuration
public class PropertiesConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(LogConfiguration.class);

	private static final String APPS_ENV = "apps_env";

	private static final String APPS_CONFIG_PATH = "apps_config_path";

	private static final String PROPERTIES = ".properties";

	private static final String APPLICATION = "app_name";

	/**
	 * Property placeholder configurer.
	 *
	 * @return the property sources placeholder configurer
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() throws FileNotFoundException {
		PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		final List<Resource> resourceLst = new ArrayList<Resource>();
		String pathToExternalProperties = System.getProperty(APPS_CONFIG_PATH);
		String env = System.getProperty(APPS_ENV);
		StringBuilder sb = new StringBuilder();
		sb.append(pathToExternalProperties).append(File.separator).append(System.getProperty(APPLICATION)).append(File.separator).append(System.getProperty(APPLICATION)).append("-")
				.append(env).append(PROPERTIES);
		File webapi = new File(sb.toString());
		if (webapi.exists()) {
			resourceLst.add(new FileSystemResource(webapi));
		} else {
			log.error("file with path: {} was not found", webapi.getAbsolutePath());
			throw new FileNotFoundException();
		}
		propertyPlaceholderConfigurer.setLocations(resourceLst.toArray(new Resource[] {}));
		return propertyPlaceholderConfigurer;
	}

}
