package com.bardiniww.account;


import org.springframework.lang.NonNull;

public interface AccountService {
    @NonNull
    Account save(@NonNull final Account account);
}
