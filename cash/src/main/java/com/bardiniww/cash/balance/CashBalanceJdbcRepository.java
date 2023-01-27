package com.bardiniww.cash.balance;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@AllArgsConstructor
class CashBalanceJdbcRepository implements CashBalanceRepository {

    private static final String SQL_GET_BALANCE =
            "SELECT COALESCE(" +
                    "(" +
                        "SELECT cb.balance as balance FROM cash_balance cb " +
                        "JOIN cash_agent ca ON cb.cash_agent_id = ca.id " +
                        "WHERE ca.account_id = :account_id" +
                    "), " +
                    "0.00::decimal" +
            ")";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public BigDecimal getBalance(@NonNull final Long accountId) {
        return namedParameterJdbcTemplate.queryForObject(
                SQL_GET_BALANCE,
                new MapSqlParameterSource()
                        .addValue("account_id", accountId),
                BigDecimal.class
        );
    }
}
