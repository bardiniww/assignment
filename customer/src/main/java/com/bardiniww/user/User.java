package com.bardiniww.user;

import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

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

    /**
     * Runtime init constructor
     */
    public User(
            @NonNull String firstName,
            @NonNull String lastName,
            @NonNull LocalDate dateOfBirth
    ) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * DAO constructor
     */
    public User(
            @NonNull Long id,
            @NonNull String firstName,
            @NonNull String lastName,
            @NonNull LocalDate dateOfBirth
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
