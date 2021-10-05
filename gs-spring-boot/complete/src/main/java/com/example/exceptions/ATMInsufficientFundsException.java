package com.example.exceptions;

public class ATMInsufficientFundsException extends Exception{

    public ATMInsufficientFundsException() {
        super("This ATM doesn't have sufficient funds");
    }
}
