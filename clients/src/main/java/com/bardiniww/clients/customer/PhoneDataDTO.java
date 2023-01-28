package com.bardiniww.clients.customer;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@AllArgsConstructor
public class PhoneDataDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    @NonNull
    private final Long id;
    @NonNull
    private final Long userId;
    @NonNull
    private final String phone;
}
