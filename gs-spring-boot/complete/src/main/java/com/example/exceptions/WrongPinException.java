package com.example.exceptions;

public class WrongPinException extends Exception {

    public WrongPinException(Long id) {
        super("Wrong Pin for account number: " + id);
    }
}
