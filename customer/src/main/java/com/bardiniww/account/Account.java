package com.bardiniww.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Getter
@ToString
@EqualsAndHashCode
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

    /**
     * Runtime init constructor
     */
    public Account(
            @NonNull Long userId,
            @NonNull String email,
            @NonNull String phoneNumber,
            @NonNull String password
    ) {
        this.id = null;
        this.userId = userId;
        this.login = email; //todo invoke from props
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * DAO constructor
     */
    public Account(
            @NonNull Long id,
            @NonNull Long userId,
            @NonNull String login,
            @NonNull String email,
            @NonNull String phoneNumber,
            @NonNull String password
    ) {
        this.id = id;
        this.userId = userId;
        this.login = login;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
