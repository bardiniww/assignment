package com.bardiniww.customer;

public class CustomerValidationException extends RuntimeException {
    public CustomerValidationException(String invalidArgName) {
        super(String.format("%s is invalid", invalidArgName));
    }
}
