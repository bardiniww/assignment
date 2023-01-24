package com.bardiniww.customer;

import com.bardiniww.account.Account;
import com.bardiniww.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CustomerRegistrationRequest {
    @NonNull
    private final User user;
    @NonNull
    private final Account account;
    @Nullable
    private final BigDecimal balance;
}
