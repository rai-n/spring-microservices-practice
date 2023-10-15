package com.neer.microservices.currencyexchangeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CircuitBreakerController {

	@GetMapping("/sampleapi")
	//@Retry(name = "sampleapi", fallbackMethod = "hardcodedResponse")
	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String sampleApi() {
//		log.info("Sample API call recevied");
//
//		ResponseEntity<String> res = new RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);
//		return res.getBody();
		return "Hello";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Fallback response";
	}

}
