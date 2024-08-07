package com.learn.gatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/contactSupport")
	public Mono<?> contactSupport(){
		return Mono.just("An Error Occurred. Please try again after some time later . ");
	}
}
