package com.bardiniww.account;


import org.springframework.lang.NonNull;

public interface AccountService {
    @NonNull
    AccountDTO save(@NonNull final Account account);
}
