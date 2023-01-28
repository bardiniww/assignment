package com.bardiniww.customer.user;

import org.springframework.lang.NonNull;

public interface UserRepository {
    User save(@NonNull final User user);
}
