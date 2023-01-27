package com.bardiniww.cash.balance;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

interface CashBalanceRepository {
    BigDecimal getBalance(@NonNull final Long accountId);
}
