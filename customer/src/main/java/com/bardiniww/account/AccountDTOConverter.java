package com.bardiniww.account;

import org.springframework.lang.NonNull;

class AccountDTOConverter {

    @NonNull
    static AccountDTO convertToDTO(@NonNull final Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .login(account.getLogin())
                .email(account.getEmail())
                .phoneNumber(account.getPhoneNumber())
                .build();
    }
}
