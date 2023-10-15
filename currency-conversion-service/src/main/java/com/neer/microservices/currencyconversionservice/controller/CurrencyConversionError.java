package com.neer.microservices.currencyconversionservice.controller;

public class CurrencyConversionError extends RuntimeException {

	public CurrencyConversionError(String message) {
		super(message);
	}
}
