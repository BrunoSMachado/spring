package com.example.springboot;

import java.util.Objects;

public class BalanceResponse {

    private Float balance;
    private Float maxWithdraw;

    public BalanceResponse(Float balance) {
        this.balance = balance;
    }

    public BalanceResponse(Float balance, Float maxWithdraw) {
        this.balance = balance;
        this.maxWithdraw = maxWithdraw;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(Float maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "balance=" + balance +
                ", maxWithdraw=" + maxWithdraw +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceResponse that = (BalanceResponse) o;
        return Objects.equals(balance, that.balance) && Objects.equals(maxWithdraw, that.maxWithdraw);
    }
}
