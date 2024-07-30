package com.learn.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.learn.accounts.dto.AccountsContactInfoDto;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.learn.accounts.controller") })
@EnableJpaRepositories("com.learn.accounts.repository")
@EntityScan("com.learn.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableFeignClients
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "Mybank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Madan Reddy",
						email = "tutor@learn.com",
						url = "https://www.learn.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.learn.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Mybank Accounts microservice REST API Documentation",
				url = "https://www.learn.com/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
