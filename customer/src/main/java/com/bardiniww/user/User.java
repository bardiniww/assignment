package com.bardiniww.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class User {
    @Nullable
    private final Long id;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final LocalDate dateOfBirth;
}
