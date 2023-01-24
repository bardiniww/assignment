package com.bardiniww.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
public class Account {
    @Nullable
    private final Long id;
    @NonNull
    private final Long userId;
    @NonNull
    private final String login;
    @NonNull
    private final String email;
    @NonNull
    private final String phoneNumber;
    @NonNull
    private final String password;

    public Account(
            @Nullable Long id,
            @NonNull Long userId,
            @NonNull String email,
            @NonNull String phoneNumber,
            @NonNull String password
    ) {
        this.id = id;
        this.userId = userId;
        this.login = email; //todo invoke from props
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
