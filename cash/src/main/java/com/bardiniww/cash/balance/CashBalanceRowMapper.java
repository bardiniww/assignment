package com.bardiniww.cash.balance;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class CashBalanceRowMapper implements RowMapper<CashBalance> {
    @Override
    public CashBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CashBalance(
                rs.getLong("cash_agent_id"),
                rs.getBigDecimal("credit"),
                rs.getBigDecimal("debit"),
                rs.getBigDecimal("balance")
        );
    }
}
