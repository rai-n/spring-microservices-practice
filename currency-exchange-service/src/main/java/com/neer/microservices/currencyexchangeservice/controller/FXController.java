package com.neer.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neer.microservices.currencyexchangeservice.beans.CurrencyExchange;
import com.neer.microservices.currencyexchangeservice.proxy.CurrencyExchangeProxy;
import com.neer.microservices.currencyexchangeservice.service.CurrencyExchangeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FXController {

	// http://localhost:8000/currency-exchange/from/USD/to/INR

	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeService service;
	
 
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		log.info("getCurrencyExchangeValue called with {} to {}", from, to);

		CurrencyExchange cex = service.getCurrencyExchange(from, to);
		cex.setEnvironment(env.getProperty("local.server.port"));
		return cex;
	}

}
