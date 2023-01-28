package com.bardiniww.customer.phone;

import org.springframework.lang.NonNull;

public interface PhoneDataService {
    boolean existsByPhone(@NonNull String email);
}
