package com.bardiniww.customer;

import org.springframework.lang.NonNull;

public interface CustomerCreationInputValidator {
    void validateEmail(@NonNull final String email);
    void validatePhone(@NonNull final String phone);
}
