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
    public BigDecimal getBalanceByAccountId(@NonNull final Long accountId) {
        return cashBalanceRepository.getBalanceByAccountId(accountId);
    }

    @NonNull
    @Override
    public BigDecimal getBalanceByCashAgentId(@NonNull final Long cashAgentId) {
        return cashBalanceRepository.getBalanceByCashAgentId(cashAgentId);
    }
}
