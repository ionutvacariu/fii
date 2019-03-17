package com.uaic.bankTrx.misc;

public class NotEnoughFundsException extends RuntimeException {
    public NotEnoughFundsException(Double amount) {
        super("Your " + amount + "$ is not enough :(");
    }
}
