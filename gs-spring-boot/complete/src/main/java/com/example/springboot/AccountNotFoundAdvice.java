package com.example.springboot;

import com.example.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AccountNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String accountNotFoundHandler(AccountNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WrongPinException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String wrongPinHandler(WrongPinException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(InvalidValueException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String invalidValueHandler(InvalidValueException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ATMInsufficientFundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String atmInsufficientFoundsHandler(ATMInsufficientFundsException ex) { return ex.getMessage(); }

    @ResponseBody
    @ExceptionHandler(AccountInsufficientFoundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String accountInsufficientFoundsHandler(AccountInsufficientFoundsException ex) { return ex.getMessage(); }


}