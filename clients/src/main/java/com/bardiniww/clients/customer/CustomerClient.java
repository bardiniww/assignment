package com.bardiniww.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "customer",
        url = "${clients.customer.url}"
)
public interface CustomerClient {
    @PostMapping("api/v1/customers")
    @NonNull
    CustomerCreationResponseDTO createCustomer(@NonNull @RequestBody CustomerCreationRequestDTO request);
}
