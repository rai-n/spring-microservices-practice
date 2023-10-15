package com.neer.microservices.currencyconversionservice.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neer.microservices.currencyconversionservice.controller.CurrencyConversion;

//@FeignClient(name="currency-exchange-service", url = "http://localhost:8100")
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, 
			@PathVariable String to);
	
}
