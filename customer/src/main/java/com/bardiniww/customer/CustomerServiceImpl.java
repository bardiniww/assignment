package com.bardiniww.customer;

import com.bardiniww.account.Account;
import com.bardiniww.account.AccountService;
import com.bardiniww.user.User;
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
    public Customer registerCustomer(@NonNull final CustomerRegistrationRequest registrationRequest) {
        final User inputUser = registrationRequest.getUser();
        final User createdUser = userService.save(new User(
                inputUser.getFirstName(),
                inputUser.getLastName(),
                inputUser.getDateOfBirth()
        ));

        final Account inputAccount = registrationRequest.getAccount();
        final Account createdAccount = accountService.save(new Account(
                Objects.requireNonNull(createdUser.getId()),
                inputAccount.getEmail(),
                inputAccount.getPhoneNumber(),
                inputAccount.getPassword()
        ));

        return new Customer(createdUser, createdAccount);
    }
}
