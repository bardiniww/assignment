package com.bardiniww.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;
}
