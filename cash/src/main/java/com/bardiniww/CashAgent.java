package com.bardiniww;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Getter
@ToString
@EqualsAndHashCode
public class CashAgent {
    @Nullable
    private final Long id;
    @NonNull
    private final Long accountId;
    @NonNull
    private final Integer typeId;

    /**
     * Runtime init constructor
     */
    public CashAgent(@NonNull Long accountId, @NonNull Integer typeId) {
        this.id = null;
        this.accountId = accountId;
        this.typeId = typeId;
    }

    /**
     * Runtime init constructor
     */
    public CashAgent(@NonNull Long accountId, @NonNull CashAgentType cashAgentType) {
        this.id = null;
        this.accountId = accountId;
        this.typeId = cashAgentType.getId();
    }

    /**
     * DAO constructor
     */
    public CashAgent(@Nullable Long id, @NonNull Long accountId, @NonNull Integer typeId) {
        this.id = id;
        this.accountId = accountId;
        this.typeId = typeId;
    }
}
