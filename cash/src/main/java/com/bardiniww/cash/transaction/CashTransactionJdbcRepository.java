package com.bardiniww.cash.transaction;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CashTransactionJdbcRepository implements CashTransactionRepository {
    private final JdbcTemplate jdbcTemplate;
}
