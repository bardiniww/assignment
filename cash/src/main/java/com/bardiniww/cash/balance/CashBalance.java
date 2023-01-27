package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CashBalance {
    @NonNull
    private final Long cashAgentId;
    @NonNull
    private final BigDecimal credit;
    @NonNull
    private final BigDecimal debit;
    @NonNull
    private final BigDecimal balance;
}
