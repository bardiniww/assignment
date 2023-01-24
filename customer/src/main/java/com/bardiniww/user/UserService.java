package com.bardiniww.user;

import org.springframework.lang.NonNull;

public interface UserService {
    @NonNull
    User save(@NonNull final User user);
}
