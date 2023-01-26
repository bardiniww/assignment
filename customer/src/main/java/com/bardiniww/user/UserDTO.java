package com.bardiniww.user;

import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserDTO {
    @Nullable
    private final Long id;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final LocalDate dateOfBirth;
}