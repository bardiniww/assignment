package com.bardiniww.clients.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class CustomerCreationRequestDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    @NonNull
    private final String name;
    @NonNull
    private final LocalDate dateOfBirth;
    @NonNull
    private final String password;
    @NonNull
    private final String email;
    @NonNull
    private final String phone;
    @NonNull
    private final BigDecimal balance;
}
