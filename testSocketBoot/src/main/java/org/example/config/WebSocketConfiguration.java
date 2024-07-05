package org.example.config;

import org.example.socket.EchoChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfiguration {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        ServerEndpointExporter exporter = new ServerEndpointExporter();
        // 手动注册 WebSocket 端点
        exporter.setAnnotatedEndpointClasses(EchoChannel.class);
        return exporter;
    }
}