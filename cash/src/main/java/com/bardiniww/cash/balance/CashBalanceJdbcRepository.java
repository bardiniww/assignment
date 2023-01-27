package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CashBalanceJdbcRepository implements CashBalanceRepository {
    private final JdbcTemplate jdbcTemplate;
}
