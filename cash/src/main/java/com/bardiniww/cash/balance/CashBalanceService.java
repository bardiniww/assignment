package com.bardiniww.cash.balance;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public interface CashBalanceService {

    @NonNull
    BigDecimal getBalanceByAccountId(@NonNull final Long accountId);

    @NonNull
    BigDecimal getBalanceByCashAgentId(@NonNull final Long cashAgentId);
}
