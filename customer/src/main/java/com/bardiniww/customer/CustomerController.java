package com.bardiniww.customer;

import com.bardiniww.clients.customer.CustomerCreationRequestDTO;
import com.bardiniww.clients.customer.CustomerCreationResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerServiceFacade customerServiceFacade;

    @PostMapping
    @Transactional
    @NonNull
    public CustomerCreationResponseDTO createCustomer(@NonNull @RequestBody CustomerCreationRequestDTO request) {
        log.info("createCustomer request passed: {}", request);
        return customerServiceFacade.createCustomer(request);
    }
}
