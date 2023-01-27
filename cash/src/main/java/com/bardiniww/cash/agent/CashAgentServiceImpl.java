package com.bardiniww.cash.agent;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CashAgentServiceImpl implements CashAgentService{
    private final CashAgentRepository cashAgentRepository;
}
