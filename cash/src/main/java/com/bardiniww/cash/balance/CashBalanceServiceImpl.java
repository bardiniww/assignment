package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CashBalanceServiceImpl implements CashBalanceService{
    private final CashBalanceDAO cashBalanceDAO;
}
