package com.bardiniww.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CustomerRegistrationRequest {
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final LocalDate dateOfBirth;
    @NonNull
    private final String login;
    @NonNull
    private final String email;
    @NonNull
    private final String phoneNumber;
    @NonNull
    private final String password;
    @Nullable
    private final BigDecimal initialBalance;
}
