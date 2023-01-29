package com.bardiniww.cash.transaction;

import org.springframework.lang.NonNull;

public interface CashTransactionService {
    @NonNull
    CashTransaction save(@NonNull final CashTransaction cashTransaction);
}
