//package com.handler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//
//public class SystemWebSocketHandler implements WebSocketHandler {
//
//    private static final Logger logger;
//
//    private static final ArrayList<WebSocketSession> users;
//
//    static {
//        users = new ArrayList<>();
//        logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);
//    }
//
////    @Autowired
////    private WebSocketService webSocketService;
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        logger.debug("connect to the websocket success......");
//        users.add(session);
//        String userName = (String) session.getAttributes().get("username");
//        if(userName!= null){
//            //查询未读消息
////            int count = webSocketService.getUnReadNews((String) session.getAttributes().get("username"));
//
//            session.sendMessage(new TextMessage(5 + ""));
//        }
//    }
//
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//
//        //sendMessageToUsers();
//    }
//
//    @Override
//    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        if(session.isOpen()){
//            session.close();
//        }
//        logger.debug("websocket connection closed......");
//        users.remove(session);
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//        logger.debug("websocket connection closed......");
//        users.remove(session);
//    }
//
//    @Override
//    public boolean supportsPartialMessages() {
//        return false;
//    }
//
//    /**
//     * 给所有在线用户发送消息
//     *
//     * @param message
//     */
//    public void sendMessageToUsers(TextMessage message) {
//        for (WebSocketSession user : users) {
//            try {
//                if (user.isOpen()) {
//                    user.sendMessage(message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 给某个用户发送消息
//     *
//     * @param userName
//     * @param message
//     */
//    public void sendMessageToUser(String userName, TextMessage message) {
//        for (WebSocketSession user : users) {
//            if (user.getAttributes().get("username").equals(userName)) {
//                try {
//                    if (user.isOpen()) {
//                        user.sendMessage(message);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//    }
//}
//
//
//
//
//
//public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
//
//    private static Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object
//                > attributes) throws Exception {
//        if (request instanceof ServletServerHttpRequest) {
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpSession session = servletRequest.getServletRequest().getSession(false);
//            if (session != null) {
//                //使用userName区分WebSocketHandler，以便定向发送消息
//                String userName = (String) session.getAttribute("username");
//                attributes.put("username",userName);
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//
//    }
//}