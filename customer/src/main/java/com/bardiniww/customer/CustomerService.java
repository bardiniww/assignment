package com.bardiniww.customer;


import org.springframework.lang.NonNull;

public interface CustomerService {
    @NonNull
    CustomerDTO registerCustomer(@NonNull final CustomerRegistrationRequest registrationRequest);
}
