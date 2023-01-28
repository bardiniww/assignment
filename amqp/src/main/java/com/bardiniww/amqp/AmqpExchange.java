package com.bardiniww.amqp;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum AmqpExchange {
    INTERNAL("internal.exchange"),
    ;

    private final String value;

    AmqpExchange(final String value) {
        this.value = value;
    }
}
