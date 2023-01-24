package com.bardiniww.cash.agent;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
//todo add migration
public enum CashAgentType {
    CUSTOMER(1, "Pure customer"),
    COMPANY(2, "Huge company")
    ;

    private final int id;
    private final String description;

    private static final Map<Integer, CashAgentType> LOOKUP_BY_ID = new HashMap<>();

    static {
        for (CashAgentType e : values()) {
            LOOKUP_BY_ID.put(e.id, e);
        }
    }

    CashAgentType(final int id, final String description) {
        this.id = id;
        this.description = description;
    }

    @NonNull
    public static CashAgentType getById(@NonNull Integer id) {
        if (!LOOKUP_BY_ID.containsKey(id)) {
            log.error("CashAgentType by id={} not found", id);
            throw new IllegalArgumentException(String.format("CashAgentType with id={%d} does not exist", id));
        }
        return LOOKUP_BY_ID.get(id);
    }
}
