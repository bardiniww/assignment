package com.bardiniww.clients.customer;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
public class CustomerCreationResponseDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    @NonNull
    private final Long userId;
    @NonNull
    private final Long accountId;
    @NonNull
    private final String name;
    @NonNull
    private final LocalDate dateOfBirth;
    @NonNull
    private final Set<EmailDataDTO> emails;
    @NonNull
    private final Set<PhoneDataDTO> phones;
}
