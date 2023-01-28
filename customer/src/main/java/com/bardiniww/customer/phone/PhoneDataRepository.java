package com.bardiniww.customer.phone;

import org.springframework.lang.NonNull;

public interface PhoneDataRepository {
    boolean existsByPhone(@NonNull final String phone);
}
