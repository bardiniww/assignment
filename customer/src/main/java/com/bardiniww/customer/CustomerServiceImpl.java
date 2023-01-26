package com.bardiniww.customer;

import com.bardiniww.account.Account;
import com.bardiniww.account.AccountDTO;
import com.bardiniww.account.AccountService;
import com.bardiniww.user.User;
import com.bardiniww.user.UserDTO;
import com.bardiniww.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final UserService userService;
    private final AccountService accountService;

    @Override
    @NonNull
    public CustomerDTO registerCustomer(@NonNull final CustomerRegistrationRequest registrationRequest) {
        final UserDTO createdUser = userService.save(new User(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getDateOfBirth()
        ));

        final AccountDTO createdAccount = accountService.save(new Account(
                Objects.requireNonNull(createdUser.getId()),
                registrationRequest.getEmail(),
                registrationRequest.getPhoneNumber(),
                registrationRequest.getPassword()
        ));

//        final BigDecimal initBalance = Optional.ofNullable(registrationRequest.getBalance()).orElse(BigDecimal.ZERO);
//        //todo send event to cash service

        return new CustomerDTO(createdUser, createdAccount);
    }
}
