package com.bardiniww.cash.amqp;

import com.bardiniww.cash.agent.CashAgentService;
import com.bardiniww.cash.transaction.CashTransaction;
import com.bardiniww.cash.transaction.CashTransactionService;
import com.bardiniww.clients.cash.CashTransactionRequestDTO;
import com.bardiniww.enums.cash.CashTransactionType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Slf4j
public class CashTransactionConsumer {
    private final CashTransactionService cashTransactionService;
    private final CashAgentService cashAgentService;

    @RabbitListener(queues = "${rabbitmq.queues.cash}")
    @Transactional
    public void process(CashTransactionRequestDTO request) {
        log.info("Consumed {} from queue", request);

        if (request.getBalance().equals(BigDecimal.ZERO)) {
            return;
        }

        final long creditorAgentId = cashAgentService
                .getAgentIdByAccount(request.getCreditorAccountId(), request.getCreditorTypeId());

        final long debtorAgentId = cashAgentService
                .getAgentIdByAccount(request.getDebtorAccountId(), request.getDebtorTypeId());

        //todo impl race control + balance check
        cashTransactionService.save(
                CashTransaction.builder()
                        .creditorCashAgentId(creditorAgentId)
                        .debtorCashAgentId(debtorAgentId)
                        .amount(request.getBalance())
                        .type(CashTransactionType.getById(request.getTransactionTypeId()))
                        .build()
        );
    }
}
