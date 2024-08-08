package com.learn.accounts.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.learn.accounts.dto.CardsDto;

@Component
public class CardsFallback implements CardsFeignClient {

	@Override
	public ResponseEntity<CardsDto> fetchCardDetails(String correlation, String mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
