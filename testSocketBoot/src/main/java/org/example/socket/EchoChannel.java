package org.example.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.po.Temp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/channel/echo")
public class EchoChannel {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoChannel.class);

    private Session session;

    //用来记录不同客户端的sessionID,区分不同客户端
    private static final Map<String, Session> SESSION_MAP = new ConcurrentHashMap<>();


    // 收到消息
    @OnMessage
    public void onMessage(String message) throws IOException{
        String clientId = getClientIdFromSession(session);
        LOGGER.info("[websocket] 收到消息：clientId={}，message={}", clientId, message);

        if (message.equalsIgnoreCase("bye")) {
            // 由服务器主动关闭连接。状态码为 NORMAL_CLOSURE（正常关闭）。
            this.session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Bye"));
            return;
        }
        Date now = new Date();
        SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        ObjectMapper mapper = new ObjectMapper();
        if (clientId.equals("[10]")) {
            Temp temp = new Temp(sdm.format(now),new Random().nextDouble() * 10 + 20);
            String json = mapper.writeValueAsString(temp);
            sendMessageToClient(clientId, json);
        }
        if (clientId.equals("[20]")) {
            Temp temp = new Temp(sdm.format(now),new Random().nextDouble() * 10 + 20);
            String json = mapper.writeValueAsString(temp);
            sendMessageToClient(clientId, json);
        }
    }

    // 获取客户端id，用来识别是哪个客户端发送的消息
    private static String getClientIdFromSession(Session session) {
        String query = session.getRequestParameterMap().get("clientId").toString();
        return query != null ? query : "";
    }

    // 发送消息的逻辑
    public static void sendMessageToClient(String clientId, String message) {
        Session session = SESSION_MAP.get(clientId);
        if (session != null && session.isOpen()) {
            try {
                session.getAsyncRemote().sendText(message);
                LOGGER.info("[websocket] 发送给指定客户端：clientId={}, message={}", clientId, message);
            } catch (Exception e) {
                LOGGER.error("[websocket] 发送消息异常：clientId={}, message={}, error={}", clientId, message, e.getMessage());
                // 处理异常情况，可能需要移除无法通信的Session
            }
        } else {
            LOGGER.warn("[websocket] 尝试发送消息到不存在或已关闭的连接：clientId={}", clientId);
        }
    }

    // 连接打开
    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig){
        // 假设这里你有方法获取客户端的唯一标识，比如从session的属性中获取
        String clientId = getClientIdFromSession(session); // 实现这个方法来获取客户端ID
        // 保存 session 到对象
        this.session = session;
        SESSION_MAP.put(clientId, session);
        LOGGER.info("[websocket] 新的连接：id={}, clientId={}", session.getId(), clientId);
    }

    // 连接关闭
    @OnClose
    public void onClose(CloseReason closeReason){
        String clientId = getClientIdFromSession(this.session); // 同样，确保实现这个方法
        SESSION_MAP.remove(clientId);
        LOGGER.info("[websocket] 连接断开：id={}，reason={}, clientId={}", this.session.getId(), closeReason, clientId);

    }

    // 连接异常
    @OnError
    public void onError(Throwable throwable) throws IOException {

        LOGGER.info("[websocket] 连接异常：id={}，throwable={}", this.session.getId(), throwable.getMessage());

        // 关闭连接。状态码为 UNEXPECTED_CONDITION（意料之外的异常）
        this.session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, throwable.getMessage()));
    }
}