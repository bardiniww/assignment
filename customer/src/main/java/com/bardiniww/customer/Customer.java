package com.bardiniww.customer;

import com.bardiniww.account.Account;
import com.bardiniww.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Customer {
    @NonNull
    private final User user;
    @NonNull
    private final Account account;
}
