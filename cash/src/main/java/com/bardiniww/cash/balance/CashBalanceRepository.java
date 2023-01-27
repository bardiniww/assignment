package com.bardiniww.cash.balance;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Optional;

interface CashBalanceRepository {
    @NonNull
    Optional<BigDecimal> getBalance(@NonNull final Long accountId);
}
