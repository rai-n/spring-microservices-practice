package com.neer.microservices.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neer.microservices.currency.bean.Limits;
import com.neer.microservices.currency.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config; 
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMin(), config.getMax());
	}
}
