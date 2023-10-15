package com.neer.microservices.currencyexchangeservice.beans;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CurrencyExchange {

	@Id
	private Integer id; 
	
	@Column(name="currency_from")
	private String from; 
	
	@Column(name="currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	
	public CurrencyExchange(Integer id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	 
	
	
}
