package com.bardiniww.customer.account;

import org.springframework.lang.NonNull;

public interface AccountRepository {
    @NonNull
    Account save(@NonNull final Account account);
}
