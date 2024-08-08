package com.learn.accounts.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.learn.accounts.dto.LoansDto;

@Component
public class LoansFallback implements LoanFeignClient {

	@Override
	public ResponseEntity<LoansDto> fetchLoanDetails(String correlation, String mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
