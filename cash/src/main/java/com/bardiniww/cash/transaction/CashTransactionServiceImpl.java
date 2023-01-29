package com.bardiniww.cash.transaction;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CashTransactionServiceImpl implements CashTransactionService {
    private final CashTransactionRepository cashTransactionRepository;

    @NonNull
    @Override
    public CashTransaction save(@NonNull final CashTransaction cashTransaction) {
        return cashTransactionRepository.save(cashTransaction);
    }
}
