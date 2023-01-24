package com.bardiniww.user;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
class UserRepository implements UserDAO{
    @Override
    @NonNull
    public User save(@NonNull final User user) {
        //todo impl
        return null;
    }
}
