package com.bardiniww.customer;

import com.bardiniww.clients.customer.CustomerCreationRequestDTO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Component
class CustomerCreationInputValidatorImpl implements CustomerCreationInputValidator {

    private static final String NAME = "NAME";
    private static final String EMAIL = "Email";
    private static final String PHONE = "Phone";
    private static final String PASSWORD = "Password";
    private static final String DATE_OF_BIRTH = "Date of birth";
    private static final String BALANCE = "Balance";

    @Override
    public void validate(@NonNull CustomerCreationRequestDTO request) {
        validateName(request.getName());
        validateEmail(request.getEmail());
        validatePhone(request.getPhone());
        validateDateOfBirth(request.getDateOfBirth());
        validateBalance(request.getBalance());
        validatePassword(request.getPassword());
    }

    private void validateName(@NonNull final String name) {
        boolean isValid = StringUtils.isNotBlank(name.trim());
        if (!isValid) {
            throw new CustomerValidationException(NAME);
        }
    }

    private void validateEmail(@NonNull final String email) {
        //todo impl email exist

        boolean isValid = StringUtils.isNotBlank(email.trim());
        if (!isValid) {
            throw new CustomerValidationException(EMAIL);
        }
    }


    private void validatePhone(@NonNull final String phone) {
        //todo impl phone exist

        boolean isValid = StringUtils.isNotBlank(phone);
        if (!isValid) {
            throw new CustomerValidationException(PHONE);
        }
    }


    private void validatePassword(@NonNull String password) {
        boolean isValid = StringUtils.isNotBlank(password) && password.length() > 7;
        if (!isValid) {
            throw new CustomerValidationException(PASSWORD);
        }
    }


    private void validateDateOfBirth(@NonNull LocalDate dateOfBirth) {
        boolean isValid = dateOfBirth.isBefore(LocalDate.now());
        if (!isValid) {
            throw new CustomerValidationException(DATE_OF_BIRTH);
        }
    }


    private void validateBalance(@NonNull BigDecimal balance) {
        boolean isValid =  balance.signum() >= 0;
        if (!isValid) {
            throw new CustomerValidationException(BALANCE);
        }
    }
}
