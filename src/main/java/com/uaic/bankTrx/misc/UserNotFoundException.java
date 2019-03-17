package com.uaic.bankTrx.misc;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with the id " + id + " was not found. :(");
    }
}
