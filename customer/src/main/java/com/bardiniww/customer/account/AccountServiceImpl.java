package com.bardiniww.customer.account;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @lombok.NonNull
    public Account save(@NonNull Account account) {
        return accountRepository.save(account);
    }
}
