package com.bardiniww.customer;

import com.bardiniww.clients.customer.CustomerCreationRequestDTO;
import org.springframework.lang.NonNull;

public interface CustomerCreationInputValidator {

    void validate(@NonNull CustomerCreationRequestDTO request);
}
