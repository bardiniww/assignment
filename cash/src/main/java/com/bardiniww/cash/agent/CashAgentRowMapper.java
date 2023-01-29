package com.bardiniww.cash.agent;

import com.bardiniww.enums.cash.CashAgentType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class CashAgentRowMapper implements RowMapper<CashAgent> {
    @Override
    public CashAgent mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CashAgent(
                rs.getLong("id"),
                rs.getLong("account_id"),
                CashAgentType.getById(rs.getInt("type_id"))
        );
    }
}
