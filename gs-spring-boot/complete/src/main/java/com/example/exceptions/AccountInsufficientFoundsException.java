package com.example.exceptions;

public class AccountInsufficientFoundsException extends Exception {
    public AccountInsufficientFoundsException() {super("This Account doesn't have sufficient Founds");}
}
