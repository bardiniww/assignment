package com.bardiniww.customer;

import com.bardiniww.clients.customer.CustomerCreationRequestDTO;
import com.bardiniww.clients.customer.CustomerCreationResponseDTO;
import org.springframework.lang.NonNull;

public interface CustomerService {
    @NonNull
    CustomerCreationResponseDTO createCustomer(@NonNull final CustomerCreationRequestDTO request);
}
