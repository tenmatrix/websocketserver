package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class TestWebSocket {

	@Test
	public void test_connect(){
		List<Transport> transports = new ArrayList<>(2);
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//		transports.add(new RestTemplateXhrTransport());
		
		SockJsClient sockJsClient = new SockJsClient(transports);
		sockJsClient.doHandshake(new WebSocketHandler(){

			@Override
			public void afterConnectionEstablished(WebSocketSession session)
					throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleMessage(WebSocketSession session,
					WebSocketMessage<?> message) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleTransportError(WebSocketSession session,
					Throwable exception) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void afterConnectionClosed(WebSocketSession session,
					CloseStatus closeStatus) throws Exception {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean supportsPartialMessages() {
				// TODO Auto-generated method stub
				return false;
			}}, "ws://localhost:7788/websocketserver/myHandler");
	}
}
