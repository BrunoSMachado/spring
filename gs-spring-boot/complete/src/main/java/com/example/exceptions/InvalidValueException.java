package com.example.exceptions;

public class InvalidValueException extends Exception{

    public InvalidValueException() {
        super("Invalid value inserted, this ATM can only provide multiple of 5 values");
    }
}
