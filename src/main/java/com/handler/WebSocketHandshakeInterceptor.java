package com.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
	private static final Logger logger = LoggerFactory
			.getLogger(WebSocketHandshakeInterceptor.class);
	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1,
			org.springframework.web.socket.WebSocketHandler arg2, Exception arg3) {
		logger.debug("WebSocketHandshakeInterceptor");		
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest arg0,
			ServerHttpResponse arg1,
			org.springframework.web.socket.WebSocketHandler arg2,
			Map<String, Object> arg3) throws Exception {
		logger.debug("beforeHandshake");
		return false;
	}
	
}