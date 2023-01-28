package com.bardiniww.customer.account;

import org.springframework.lang.NonNull;

public interface AccountService {
    Account save(@NonNull final Account account);
}
