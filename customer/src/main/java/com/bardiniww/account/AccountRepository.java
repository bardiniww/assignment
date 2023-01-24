package com.bardiniww.account;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
class AccountRepository implements AccountDAO {
    @Override
    @NonNull
    public Account save(@NonNull final Account account) {
        //todo impl
        return null;
    }
}
