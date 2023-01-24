package com.bardiniww.cash.transaction;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
//todo add migration
public enum CashTransactionType {
    USER_INIT(1, "Initial accrual"),
    TRANSFER(1, "Money transfer"),
    PURCHASE(2, "Purchase operation")
    ;

    private final int id;
    private final String description;

    private static final Map<Integer, CashTransactionType> LOOKUP_BY_ID = new HashMap<>();

    static {
        for (CashTransactionType e : values()) {
            LOOKUP_BY_ID.put(e.id, e);
        }
    }

    CashTransactionType(final int id, final String description) {
        this.id = id;
        this.description = description;
    }

    @NonNull
    public static CashTransactionType getById(@NonNull Integer id) {
        if (!LOOKUP_BY_ID.containsKey(id)) {
            log.error("CashTransactionType by id={} not found", id);
            throw new IllegalArgumentException(String.format("CashAgentType with id={%d} does not exist", id));
        }
        return LOOKUP_BY_ID.get(id);
    }
}
