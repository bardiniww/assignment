package com.bardiniww.user;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Override
    @NonNull
    public UserDTO save(@NonNull final User user) {
        return UserDTOConverter.convertToDTO(userDAO.save(user));
    }
}
