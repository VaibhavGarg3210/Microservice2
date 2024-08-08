package com.learn.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.accounts.dto.CardsDto;

@FeignClient(name = "cards",fallback = CardsFallback.class) // when eureka register carts get instance details
public interface CardsFeignClient {

	@GetMapping(value = "/api/fetch",consumes = "application/json")
	public ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("learn-correclation-id") String correlation,@RequestParam String mobileNumber);

}
