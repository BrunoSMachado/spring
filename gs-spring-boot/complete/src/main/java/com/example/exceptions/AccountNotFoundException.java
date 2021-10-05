package com.example.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(Long id) {
        super("Could not find Account " + id);
    }
}

