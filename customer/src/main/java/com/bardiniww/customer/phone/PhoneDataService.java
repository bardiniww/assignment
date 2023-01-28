package com.bardiniww.customer.phone;

import org.springframework.lang.NonNull;

public interface PhoneDataService {
    boolean existsByPhone(@NonNull final String email);

    @NonNull
    PhoneData save(@NonNull final PhoneData phoneData);
}
