package com.neer.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neer.microservices.currencyexchangeservice.beans.CurrencyExchange;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Integer> {

	public CurrencyExchange findByFromAndTo(String from, String to);
 
}
