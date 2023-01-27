package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CashBalanceServiceImpl implements CashBalanceService {
    private final CashBalanceRepository cashBalanceRepository;

    @Override
    @NonNull
    public BigDecimal getBalance(@NonNull Long accountId) {
        return cashBalanceRepository.getBalance(accountId);
    }
}
