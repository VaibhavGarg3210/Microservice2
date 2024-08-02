package com.learn.gatewayserver.filters;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class FilterUtility {

	public static final String CORRELATION_ID = "learn-correclation-id";

	/**
	 * @param exchange
	 * @param correlatioId
	 * @return
	 */
	public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlatioId) {
		// TODO Auto-generated method stub
		return this.setRequestHeader(exchange, CORRELATION_ID, correlatioId);
	}

	/**
	 * @param exchange
	 * @param correlationId
	 * @param correlatioId
	 * @return
	 */
	private ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
		// TODO Auto-generated method stub
		return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
	}

	/**
	 * @param requestHeader
	 * @return
	 */
	public String getCorrelationId(HttpHeaders requestHeader) {
		if (requestHeader.get(CORRELATION_ID) != null) {
			List<String> reqHeaderList = requestHeader.get(CORRELATION_ID);
			return reqHeaderList.stream().findFirst().get();
		} else {
			return null;
		}
	}

}
