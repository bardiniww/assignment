package com.bardiniww.user;

import org.springframework.lang.NonNull;

class UserDTOConverter {

    @NonNull
    static UserDTO convertToDTO(@NonNull final User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

    private UserDTOConverter() {}
}
