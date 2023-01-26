package com.bardiniww.account;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @NonNull
    public AccountDTO save(@NonNull final Account account) {
        //todo check login, email, phoneNumber exist

        return AccountDTOConverter.convertToDTO(accountRepository.save(account));
    }
}
