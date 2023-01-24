package com.bardiniww.account;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountDAO accountDAO;

    @Override
    @NonNull
    public Account save(@NonNull final Account account) {
        //check login, email, phoneNumber exist
        return accountDAO.save(account);
    }
}
