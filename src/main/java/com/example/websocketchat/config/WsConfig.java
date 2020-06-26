package com.example.websocketchat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    //da pra criar múltiplos endpoints
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/javatechie").withSockJS();
        /*se o websocket desconectar ou a conexão nao puder ser feita, a conexão mudará para Http
        * e a comunicação entre client e server irá continuar */
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); //coloca as mensagens no message broker
        registry.setApplicationDestinationPrefixes("/app");
        //a msm url precisa ser configurada no client
    }
}
