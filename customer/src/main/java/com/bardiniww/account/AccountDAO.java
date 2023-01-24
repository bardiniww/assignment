package com.bardiniww.account;

import org.springframework.lang.NonNull;

public interface AccountDAO {
    @NonNull
    Account save(@NonNull final Account account);
}
