package com.bardiniww.clients.cash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@Getter
public class CashTransactionDTO {
    @NonNull
    private final Long creditorAccountId;
    @NonNull
    private final Integer creditorTypeId;
    @NonNull
    private final Long debtorAccountId;
    @NonNull
    private final Integer debtorTypeId;
    @NonNull
    private final Integer transactionTypeId;
}
