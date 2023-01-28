package com.bardiniww.customer.user;

import org.springframework.lang.NonNull;

public interface UserService {
    User save(@NonNull final User user);
}
