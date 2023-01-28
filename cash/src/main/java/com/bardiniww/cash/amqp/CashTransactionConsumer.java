package com.bardiniww.cash.amqp;

import com.bardiniww.cash.transaction.CashTransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CashTransactionConsumer {
    private final CashTransactionService cashTransactionService;

    @RabbitListener(queues = "${rabbitmq.queues.cash}")
    public void process(Object notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        //todo impl
//        cashTransactionService.save(notificationRequest);
    }
}
