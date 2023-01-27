package com.bardiniww.cash.transaction;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class CashTransactionRowMapper implements RowMapper<CashTransaction> {
    @Override
    public CashTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CashTransaction(
                rs.getLong("id"),
                rs.getLong("creditor_cash_agent_id"),
                rs.getLong("debtor_cash_agent_id"),
                rs.getBigDecimal("amount"),
                CashTransactionType.getById(rs.getInt("type_id"))
        );
    }
}
