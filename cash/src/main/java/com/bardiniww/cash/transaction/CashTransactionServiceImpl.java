package com.bardiniww.cash.transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CashTransactionServiceImpl implements CashTransactionService {
    private final CashTransactionRepository cashTransactionRepository;
}
