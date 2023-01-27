package com.bardiniww.cash.agent;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

class CashAgentRowMapper implements RowMapper<CashAgent> {
    @Nullable
    @Override
    public CashAgent mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CashAgent(
                rs.getLong("id"),
                rs.getLong("account_id"),
                rs.getInt("type_id")
        );
    }
}
