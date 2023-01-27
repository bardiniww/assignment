package com.bardiniww.cash.balance;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public interface CashBalanceService {

    @NonNull
    BigDecimal getBalance(@NonNull final Long accountId);
}
