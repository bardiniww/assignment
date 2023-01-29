package com.bardiniww.cash.agent;

import com.bardiniww.enums.cash.CashAgentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
@Builder
public class CashAgent {
    @Nullable
    private final Long id;
    @NonNull
    private final Long accountId;
    @NonNull
    private final CashAgentType type;
}
