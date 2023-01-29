package com.bardiniww.cash.transaction;

import com.bardiniww.enums.cash.CashTransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
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
