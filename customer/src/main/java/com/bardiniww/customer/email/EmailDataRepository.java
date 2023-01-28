package com.bardiniww.customer.email;

import org.springframework.lang.NonNull;

public interface EmailDataRepository {
    boolean existsByEmail(@NonNull final String email);

    @NonNull
    EmailData save(@NonNull final EmailData emailData);
}
