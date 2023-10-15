package com.neer.microservices.currency.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("limits-service")
@Data
public class Configuration {

	private int min;
	private int max; 
}
