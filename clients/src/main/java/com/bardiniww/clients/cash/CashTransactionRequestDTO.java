package com.bardiniww.clients.cash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CashTransactionRequestDTO {
    @NonNull
    private Long creditorAccountId;
    @NonNull
    private Integer creditorTypeId;
    @NonNull
    private Long debtorAccountId;
    @NonNull
    private Integer debtorTypeId;
    @NonNull
    private BigDecimal balance;
    @NonNull
    private Integer transactionTypeId;
}