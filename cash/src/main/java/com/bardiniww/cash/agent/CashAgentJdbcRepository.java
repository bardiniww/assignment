package com.bardiniww.cash.agent;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CashAgentJdbcRepository implements CashAgentRepository {

    private static final String SQL_INSERT =
            "INSERT INTO cash_agent(account_id, type_id) " +
            "VALUES(:account_id, :type_id) " +
            "RETURNING *";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public CashAgent save(CashAgent cashAgent) {

        return namedParameterJdbcTemplate.queryForObject(
                SQL_INSERT,
                new MapSqlParameterSource()
                        .addValue("account_id", cashAgent.getAccountId())
                        .addValue("type_id", cashAgent.getType().getId()),
                new CashAgentRowMapper()
        );
    }
}
