package com.learn.gatewayserver;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator learnBankRoute(RouteLocatorBuilder routeLocator) {
		return routeLocator.routes()
				.route(p -> p.path("/learn/accounts/**")
						.filters(f -> f.rewritePath("/learn/accounts/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("accountCircuitBreaker").setFallbackUri("forward:/contactSupport")))
						.uri("lb://ACCOUNTS"))
				.route(p -> p.path("/learn/cards/**")
						.filters(f -> f.rewritePath("/learn/cards/(?<segment>.*)", "/${segment}")).uri("lb://CARDS"))
				.route(p -> p.path("/learn/loans/**")
						.filters(f -> f.rewritePath("/learn/loans/(?<segment>.*)", "/${segment}")).uri("lb://LOANS"))
				.build();

	}

}
