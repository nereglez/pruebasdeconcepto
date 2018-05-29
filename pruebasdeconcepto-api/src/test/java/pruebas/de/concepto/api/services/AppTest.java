package pruebas.de.concepto.api.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("pruebas.de.concepto")
@EnableJpaRepositories(basePackages="pruebas.de.concepto.persistence.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="pruebas.de.concepto.persistence.entities")
public class AppTest {
	
}
