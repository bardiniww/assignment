package com.bardiniww.cash.transaction;

import com.bardiniww.cash.balance.CashBalanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Slf4j
public class CashTransactionServiceImpl implements CashTransactionService {

    private static final Long SYSTEM_CASH_AGENT_ID = 0L;

    private final CashTransactionRepository cashTransactionRepository;
    private final CashBalanceService cashBalanceService;

    /**
     * Method checks if a creditor has enough balance amounts before processing
     *  - if yes, saves transaction
     *  - if no, throws exception
     *
     * @param cashTransaction entity to save
     * @return stored transaction entity if success
     */
    @NonNull
    @Override
    public CashTransaction save(@NonNull final CashTransaction cashTransaction) {
        validateIfCreditorBalanceIsCorrectToProcessTransaction(
                cashTransaction.getCreditorCashAgentId(),
                cashTransaction.getAmount()
        );
        return cashTransactionRepository.save(cashTransaction);
    }


    private void validateIfCreditorBalanceIsCorrectToProcessTransaction(
            @NonNull final Long creditorCashAgentId,
            @NonNull final BigDecimal transactionAmount
    ) {
        if (SYSTEM_CASH_AGENT_ID.equals(creditorCashAgentId)) {
            return;
        }

        final BigDecimal creditorBalance = cashBalanceService.getBalanceByCashAgentId(creditorCashAgentId);

        if (creditorBalance.compareTo(transactionAmount) < 0) {
            //todo impl
            // add initiatorId to transaction dto
            // send notification with transaction cancel message to initiator
            log.error(
                    "Operation will no be processed. Creditor balance is less then transaction amount. " +
                    "CreditorCashAgentId={}; CreditorBalance={}; TransactionAmount={}",
                    creditorCashAgentId,
                    creditorBalance,
                    transactionAmount
            );

            throw new RuntimeException("Operation will no be processed. Creditor balance is less then transaction amount.");
        }
    }
}
