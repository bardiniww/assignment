package com.bardiniww.cash.agent;

import com.bardiniww.enums.cash.CashAgentType;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CashAgentServiceImpl implements CashAgentService {
    private final CashAgentRepository cashAgentRepository;

    @Override
    public Long getAgentIdByAccount(@NonNull final Long creditorAccountId, @NonNull final Integer creditorTypeId) {
        return cashAgentRepository
                .findAgentIdByAccountId(creditorAccountId)
                .orElseGet(() -> cashAgentRepository.save(
                                CashAgent.builder()
                                        .id(null)
                                        .accountId(creditorAccountId)
                                        .type(CashAgentType.getById(creditorTypeId))
                                        .build()).getId()
                );
    }
}
