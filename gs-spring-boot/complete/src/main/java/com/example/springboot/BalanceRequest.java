package com.example.springboot;

import java.util.Objects;

public class BalanceRequest {

    private Long accountNumber;
    private Integer pin;

    public BalanceRequest(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BalanceRequest(Long accountNumber, Integer pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "BalanceRequest{" +
                "accountNumber=" + accountNumber +
                ", pin=" + pin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceRequest that = (BalanceRequest) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(pin, that.pin);
    }
}
