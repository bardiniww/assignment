package com.bardiniww.cash.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CashTransaction {
    @Nullable
    private final Long id;
    @NonNull
    private final Long creditorCashAgentId;
    @NonNull
    private final Long debtorCashAgentId;
    @NonNull
    private final BigDecimal amount;
    @NonNull
    private final CashTransactionType type;
}
