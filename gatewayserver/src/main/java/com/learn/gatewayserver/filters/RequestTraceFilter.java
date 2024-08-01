package com.learn.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

	private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);
	@Autowired
	FilterUtility filter;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		HttpHeaders requestHeader = exchange.getRequest().getHeaders();
		if (isCorrelationIdPresent(requestHeader)) {
			logger.debug("correlation_id found in RequestTraceFilter :{}", filter.getCorrelationId(requestHeader));
		} else {
			String correlatioId = generateCorrelationId();
			exchange = filter.setCorrelationId(exchange, correlatioId);
			logger.debug("correlation_id found in RequestTraceFilter :{}", filter.getCorrelationId(requestHeader));
		}
		return chain.filter(exchange);
	}

	/**
	 * @return
	 */
	private String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}

	/**
	 * @param requestHeader
	 * @return
	 */
	private boolean isCorrelationIdPresent(HttpHeaders requestHeader) {
		if (filter.getCorrelationId(requestHeader) != null)
			return true;
		else
			return false;
	}

}
