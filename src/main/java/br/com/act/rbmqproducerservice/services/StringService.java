package br.com.act.rbmqproducerservice.services;

import br.com.act.rbmqproducerservice.configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

    private  final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("\u001B[42m Received message " + message + "\u001B[40m");
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, message);
    }
}
