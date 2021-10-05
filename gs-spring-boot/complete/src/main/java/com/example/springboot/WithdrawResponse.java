package com.example.springboot;

import java.util.Objects;

public class WithdrawResponse {

    private Float balance;
    private Integer bill50;
    private Integer bill20;
    private Integer bill10;
    private Integer bill5;

    public WithdrawResponse() {
    }

    public WithdrawResponse(Float balance, Integer bill50, Integer bill20, Integer bill10, Integer bill5) {
        this.balance = balance;
        this.bill50 = bill50;
        this.bill20 = bill20;
        this.bill10 = bill10;
        this.bill5 = bill5;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Integer getBill50() {
        return bill50;
    }

    public void setBill50(Integer bill50) {
        this.bill50 = bill50;
    }

    public Integer getBill20() {
        return bill20;
    }

    public void setBill20(Integer bill20) {
        this.bill20 = bill20;
    }

    public Integer getBill10() {
        return bill10;
    }

    public void setBill10(Integer bill10) {
        this.bill10 = bill10;
    }

    public Integer getBill5() {
        return bill5;
    }

    public void setBill5(Integer bill5) {
        this.bill5 = bill5;
    }

    @Override
    public String toString() {
        return "WithdrawResponse{" +
                "balance=" + balance +
                ", bill50=" + bill50 +
                ", bill20=" + bill20 +
                ", bill10=" + bill10 +
                ", bill5=" + bill5 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithdrawResponse that = (WithdrawResponse) o;
        return Objects.equals(balance, that.balance) && Objects.equals(bill50, that.bill50) && Objects.equals(bill20, that.bill20) && Objects.equals(bill10, that.bill10) && Objects.equals(bill5, that.bill5);
    }
}
