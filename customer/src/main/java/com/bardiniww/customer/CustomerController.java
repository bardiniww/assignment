package com.bardiniww.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @NonNull
    @Transactional
    public ResponseEntity<CustomerDTO> registerCustomer(@Valid @NonNull @RequestBody final CustomerRegistrationRequest registrationRequest) {
        log.info("customer registration request {}", registrationRequest);
        final CustomerDTO createdCustomerDTO = customerService.registerCustomer(registrationRequest);
        return ResponseEntity.ok(createdCustomerDTO);
    }
}
