package com.bardiniww.cash.agent;

import org.springframework.lang.NonNull;

import java.util.Optional;

interface CashAgentRepository {
    @NonNull
    CashAgent save(@NonNull final CashAgent cashAgent);
    @NonNull
    Optional<Long> findAgentIdByAccountId(@NonNull final Long creditorAccountId);
}
