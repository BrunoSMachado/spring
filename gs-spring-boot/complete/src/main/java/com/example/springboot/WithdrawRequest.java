package com.example.springboot;

import java.util.Objects;

public class WithdrawRequest {

    private Long accountNumber;
    private Integer pin;
    private Integer withdraw;

    public WithdrawRequest() {

    }

    public WithdrawRequest(Long accountNumber, Integer pin, Integer withdraw) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.withdraw = withdraw;
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

    public Integer getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Integer withdraw) {
        this.withdraw = withdraw;
    }

    @Override
    public String toString() {
        return "WithdrawRequest{" +
                "accountNumber=" + accountNumber +
                ", pin=" + pin +
                ", withdraw=" + withdraw +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithdrawRequest that = (WithdrawRequest) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(pin, that.pin) && Objects.equals(withdraw, that.withdraw);
    }
}
