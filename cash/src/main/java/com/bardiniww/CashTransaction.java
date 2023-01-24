package com.bardiniww;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@ToString
public class CashTransaction {
    @Nullable
    private final Long id;
    @NonNull
    private final Long creditorId;
    @NonNull
    private final Integer typeId;
    @NonNull
    private final BigDecimal amount;

    /**
     * Runtime init constructor
     */
    public CashTransaction(
            @NonNull Long creditorId,
            @NonNull Integer typeId,
            @NonNull BigDecimal amount
    ) {
        this.id = null;
        this.creditorId = creditorId;
        this.typeId = typeId;
        this.amount = amount;
    }

    /**
     * DAO constructor
     */
    public CashTransaction(
            @NonNull Long id,
            @NonNull Long creditorId,
            @NonNull Integer typeId,
            @NonNull BigDecimal amount
    ) {
        this.id = id;
        this.creditorId = creditorId;
        this.typeId = typeId;
        this.amount = amount;
    }
}
