package com.bardiniww.clients.cash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CashTransactionDTO {
    @NonNull
    private Long creditorAccountId;
    @NonNull
    private Integer creditorTypeId;
    @NonNull
    private Long debtorAccountId;
    @NonNull
    private Integer debtorTypeId;
    @NonNull
    private Integer transactionTypeId;
}
