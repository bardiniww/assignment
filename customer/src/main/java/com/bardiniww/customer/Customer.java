package com.bardiniww.customer;

import com.bardiniww.account.Account;
import com.bardiniww.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@Getter
public class Customer {
    @NonNull
    private final User user;
    @NonNull
    private final Account account;
}
