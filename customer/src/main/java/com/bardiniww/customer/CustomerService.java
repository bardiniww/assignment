package com.bardiniww.customer;


import org.springframework.lang.NonNull;

public interface CustomerService {
    @NonNull
    Customer registerCustomer(@NonNull final CustomerRegistrationRequest registrationRequest);
}
