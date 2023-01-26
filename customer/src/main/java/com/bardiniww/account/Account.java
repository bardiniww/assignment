package com.bardiniww.account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor
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
}
