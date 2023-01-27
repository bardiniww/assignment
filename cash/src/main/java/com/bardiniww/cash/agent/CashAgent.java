package com.bardiniww.cash.agent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
public class CashAgent {
    @Nullable
    private final Long id;
    @NonNull
    private final Long accountId;
    @NonNull
    private final Integer typeId;
}
