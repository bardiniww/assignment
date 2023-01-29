package com.bardiniww.cash.balance;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

interface CashBalanceRepository {
    BigDecimal getBalanceByAccountId(@NonNull final Long accountId);
    BigDecimal getBalanceByCashAgentId(@NonNull final Long cashAgentId);
}
