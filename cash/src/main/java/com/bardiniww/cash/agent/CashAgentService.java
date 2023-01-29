package com.bardiniww.cash.agent;

import org.springframework.lang.NonNull;

public interface CashAgentService {
    Long getAgentIdByAccount(
            @NonNull final Long creditorAccountId,
            @NonNull final Integer creditorTypeId
    );
}
