package com.bardiniww.cash.transaction;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@AllArgsConstructor
@Repository
public class CashTransactionJdbcRepository implements CashTransactionRepository {

    private static final String SQL_INSERT =
            "INSERT INTO cash_transaction(" +
                    "creditor_cash_agent_id, " +
                    "debtor_cash_agent_id, " +
                    "amount, " +
                    "type_id" +
            ") " +
            "VALUES(" +
                    ":creditor_cash_agent_id, " +
                    ":debtor_cash_agent_id, " +
                    ":amount, " +
                    ":type_id" +
            ") " +
            "RETURNING *";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @NonNull
    @Override
    public CashTransaction save(@NonNull final CashTransaction cashTransaction) {
        return Objects.requireNonNull(namedParameterJdbcTemplate.queryForObject(
                SQL_INSERT,
                new MapSqlParameterSource()
                        .addValue("creditor_cash_agent_id", cashTransaction.getCreditorCashAgentId())
                        .addValue("debtor_cash_agent_id", cashTransaction.getDebtorCashAgentId())
                        .addValue("amount", cashTransaction.getAmount())
                        .addValue("type_id", cashTransaction.getType().getId()),
                new CashTransactionRowMapper()
        ));
    }
}
