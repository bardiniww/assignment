package com.bardiniww.customer;


import org.springframework.lang.NonNull;

public interface CustomerService {
    @NonNull
    CustomerDTO createCustomer(@NonNull final CustomerRegistrationRequest registrationRequest);
}
