package com.bardiniww.customer;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class CustomerCreationInputValidatorImpl implements CustomerCreationInputValidator {

    private static final String EMAIL = "Email";
    private static final String PHONE = "Phone";

    @Override
    public void validateEmail(@NonNull final String email) {
        //todo impl
        boolean isValid = StringUtils.isNotBlank(email.trim());
        if (!isValid) {
            throw new CustomerValidationException(EMAIL);
        }
    }

    @Override
    public void validatePhone(@NonNull final String phone) {
        //todo impl
        boolean isValid = StringUtils.isNotBlank(phone);
        if (!isValid) {
            throw new CustomerValidationException(PHONE);
        }
    }
}
