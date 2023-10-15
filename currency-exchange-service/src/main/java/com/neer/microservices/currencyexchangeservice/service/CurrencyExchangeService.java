package com.neer.microservices.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neer.microservices.currencyexchangeservice.beans.CurrencyExchange;
import com.neer.microservices.currencyexchangeservice.repository.CurrencyExchangeRepo;

@Service
public class CurrencyExchangeService {

	@Autowired
	CurrencyExchangeRepo repo; 
	
	public CurrencyExchange getCurrencyExchange(String from, String to) {
		return repo.findByFromAndTo(from, to);
	}
}
