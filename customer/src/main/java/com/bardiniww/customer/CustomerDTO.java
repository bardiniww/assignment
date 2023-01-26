package com.bardiniww.customer;

import com.bardiniww.account.AccountDTO;
import com.bardiniww.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CustomerDTO {
    @NonNull
    private final UserDTO user;
    @NonNull
    private final AccountDTO account;
}
