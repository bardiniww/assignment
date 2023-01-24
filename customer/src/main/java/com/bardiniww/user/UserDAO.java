package com.bardiniww.user;

import org.springframework.lang.NonNull;

interface UserDAO {
    @NonNull
    User save(@NonNull final User user);
}
