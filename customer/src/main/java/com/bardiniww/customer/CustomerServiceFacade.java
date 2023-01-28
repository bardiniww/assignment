package com.bardiniww.customer;

import com.bardiniww.clients.customer.CustomerCreationRequestDTO;
import com.bardiniww.clients.customer.CustomerCreationResponseDTO;
import com.bardiniww.customer.account.AccountService;
import com.bardiniww.customer.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceFacade implements CustomerService {
    private final UserService userService;
    private final AccountService accountService;

    @NonNull
    public CustomerCreationResponseDTO createCustomer(@NonNull final CustomerCreationRequestDTO request) {
        //todo impl
        return null;
    }
}
