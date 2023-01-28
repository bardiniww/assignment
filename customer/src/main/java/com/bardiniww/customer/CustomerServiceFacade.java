package com.bardiniww.customer;

import com.bardiniww.amqp.AmqpExchange;
import com.bardiniww.amqp.AmqpRoutingKey;
import com.bardiniww.amqp.RabbitMQMessageProducer;
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
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final CustomerCreationInputValidator customerCreationInputValidator;

    @NonNull
    public CustomerCreationResponseDTO createCustomer(@NonNull final CustomerCreationRequestDTO request) {
        customerCreationInputValidator.validate(request);



        //todo send transaction
        rabbitMQMessageProducer.publish(new Object(), AmqpExchange.INTERNAL.getValue(), AmqpRoutingKey.CASH.getValue());
        return null;
    }

}
