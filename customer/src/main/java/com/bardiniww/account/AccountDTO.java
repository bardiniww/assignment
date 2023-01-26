package com.bardiniww.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
@AllArgsConstructor
@Builder
public class AccountDTO {
    @NonNull
    private final Long id;
    @NonNull
    private final Long userId;
    @NonNull
    private final String login;
    @NonNull
    private final String email;
    @NonNull
    private final String phoneNumber;
}
