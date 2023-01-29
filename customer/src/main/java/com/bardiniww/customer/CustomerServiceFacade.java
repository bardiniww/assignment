package com.bardiniww.customer;

import com.bardiniww.amqp.RabbitMQMessageProducer;
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

        //todo проверить что работает
        // проверить рэббит
        // написать импл на сохранение транзакции + создание агента
        // сделать миграции флайфей при старте бд + создание бд
        // сделать докеры для сервисов
        // добавить секьюрити
        // добавить шедуллер
        // написать тесты
        // добавить свагер
        // добавить кеширование
        // добавить фронт
        // добавить ci/cd
        // добавить задеплоить на авс

        //todo impl
//        rabbitMQMessageProducer.publish(new Object(), AmqpExchange.INTERNAL.getValue(), AmqpRoutingKey.CASH.getValue());
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
