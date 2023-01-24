package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class CashBalance {
    @NonNull
    private final Long cashAgentId;
    @NonNull
    private final BigDecimal debit;
    @NonNull
    private final BigDecimal credit;
    @NonNull
    private final BigDecimal amount;
}
