package com.neer.microservices.apigatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("currencyExchangeRoute", routeSpec -> routeSpec.path("/currency-exchange/**")
						.filters(f -> f.addResponseHeader("Response-Header", "CE-S-Test")
								.addRequestHeader("AUTHORIZATION", "CATS").addRequestParameter("Param", "MyValue"))
						.uri("lb://CURRENCY-EXCHANGE-SERVICE"))
				.route("currencyConversionRoute",
						routeSpec -> routeSpec.path("/currency-conversion**/**")
								.filters(f -> f.addRequestHeader("Response-Header", "CC-S-Test"))
								.uri("lb://CURRENCY-CONVERSION-SERVICE"))
				.build();

	}
}
