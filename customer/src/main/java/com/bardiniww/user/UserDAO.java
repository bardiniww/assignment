package com.bardiniww.user;

import org.springframework.lang.NonNull;

public interface UserDAO {
    @NonNull
    User save(@NonNull final User user);
}
