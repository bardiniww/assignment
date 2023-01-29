package com.bardiniww.customer;

import com.bardiniww.amqp.AmqpExchange;
import com.bardiniww.amqp.AmqpRoutingKey;
import com.bardiniww.amqp.RabbitMQMessageProducer;
import com.bardiniww.clients.cash.CashTransactionRequestDTO;
import com.bardiniww.clients.customer.CustomerCreationRequestDTO;
import com.bardiniww.clients.customer.CustomerCreationResponseDTO;
import com.bardiniww.customer.account.Account;
import com.bardiniww.customer.account.AccountService;
import com.bardiniww.customer.email.EmailData;
import com.bardiniww.customer.email.EmailDataService;
import com.bardiniww.customer.phone.PhoneData;
import com.bardiniww.customer.phone.PhoneDataService;
import com.bardiniww.customer.user.User;
import com.bardiniww.customer.user.UserService;
import com.bardiniww.enums.cash.CashAgentType;
import com.bardiniww.enums.cash.CashTransactionType;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceFacade implements CustomerService {
    private final UserService userService;
    private final AccountService accountService;
    private final EmailDataService emailDataService;
    private final PhoneDataService phoneDataService;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final CustomerCreationInputValidator customerCreationInputValidator;

    @NonNull
    public CustomerCreationResponseDTO createCustomer(@NonNull final CustomerCreationRequestDTO request) {
        customerCreationInputValidator.validate(request);

        final User createdUser = userService.save(
                User.builder()
                        .name(request.getName())
                        .password(request.getPassword())
                        .dateOfBirth(request.getDateOfBirth())
                        .build()
        );
        final Account createdAccount = accountService.save(
                Account.builder()
                        .user(createdUser)
                        .build()
        );
        final EmailData email = emailDataService.save(
                EmailData.builder()
                        .email(request.getEmail())
                        .user(createdUser)
                        .build()
        );

        final PhoneData phone = phoneDataService.save(
                PhoneData.builder()
                        .phone(request.getPhone())
                        .user(createdUser)
                        .build()
        );

        final CashTransactionRequestDTO userInitCashTransaction = new CashTransactionRequestDTO(
                0L,
                CashAgentType.SYSTEM.getId(),
                createdAccount.getId(),
                CashAgentType.CUSTOMER.getId(),
                request.getBalance(),
                CashTransactionType.USER_INIT.getId()
        );
        rabbitMQMessageProducer.publish(
                userInitCashTransaction,
                AmqpExchange.INTERNAL.getValue(),
                AmqpRoutingKey.CASH.getValue()
        );

        return new CustomerCreationResponseDTO(
                createdUser.getId(),
                createdAccount.getId(),
                createdUser.getName(),
                createdUser.getDateOfBirth(),
                email.getEmail(),
                phone.getPhone()
        );
    }

}
