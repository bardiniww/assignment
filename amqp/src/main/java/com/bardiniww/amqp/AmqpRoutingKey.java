package com.bardiniww.amqp;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum AmqpRoutingKey {
    CASH("internal.cash.routing-key"),
    ;

    private final String value;

    AmqpRoutingKey(final String value) {
        this.value = value;
    }
}
