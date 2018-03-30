package edu.uncc.ssdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.uncc.ssdi.repositories.UserRepository;

@SpringBootApplication(scanBasePackages={"edu.uncc.ssdi.controllers","edu.uncc.ssdi.service", "edu.uncc.ssdi.repositories","edu.uncc.ssdi.model"})

public class SpringBootBasewebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasewebappApplication.class, args);
	}
}
