package com.bardiniww.cash.agent;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CashAgentJdbcRepository implements CashAgentRepository {

    private static final String SQL_INSERT =
            "INSERT INTO cash_agent(account_id, type_id) " +
            "VALUES(:account_id, :type_id) " +
            "RETURNING *";

    private static final String SQL_FIND_ID_BY_ACCOUNT_ID =
            "SELECT id FROM cash_agent " +
            "WHERE account_id = :account_id";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    @NonNull
    public CashAgent save(@NonNull final CashAgent cashAgent) {
        return Objects.requireNonNull(namedParameterJdbcTemplate.queryForObject(
                SQL_INSERT,
                new MapSqlParameterSource()
                        .addValue("account_id", cashAgent.getAccountId())
                        .addValue("type_id", cashAgent.getType().getId()),
                new CashAgentRowMapper()
        ));
    }

    @NonNull
    @Override
    public Optional<Long> findAgentIdByAccountId(@NonNull Long creditorAccountId) {
        return Optional.ofNullable(namedParameterJdbcTemplate.query(
                SQL_FIND_ID_BY_ACCOUNT_ID,
                new MapSqlParameterSource()
                        .addValue("account_id", creditorAccountId),
                rs -> {
                    if (rs.next()) {
                        return rs.getLong("id");
                    }
                    return null;
                }
        ));
    }
}
