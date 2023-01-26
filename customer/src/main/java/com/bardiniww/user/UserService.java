package com.bardiniww.user;

import org.springframework.lang.NonNull;

public interface UserService {
    @NonNull
    UserDTO save(@NonNull final User user);
}
