package com.bardiniww.customer.user;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @NonNull
    public User save(@NonNull final User user) {
        return userRepository.save(user);
    }
}
