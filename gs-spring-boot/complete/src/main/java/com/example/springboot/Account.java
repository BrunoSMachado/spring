package com.example.springboot;

import com.example.exceptions.AccountInsufficientFoundsException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    private @Id
    @GeneratedValue
    Long accountNumber;
    private Float balance;
    private Integer overdraft;
    private Integer pin;

    public Account() {

    }

    public Account(Float balance, Integer overdraft, Integer pin) {
        this.balance = balance;
        this.overdraft = overdraft;
        this.pin = pin;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Integer getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Integer overdraft) {
        this.overdraft = overdraft;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Account account = (Account) object;
        return accountNumber.equals(account.accountNumber) && balance.equals(account.balance) && java.util.Objects.equals(overdraft, account.overdraft) && pin.equals(account.pin);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", overdraft=" + overdraft +
                ", pin=" + pin +
                '}';
    }

    public void withdraw(Integer withdraw) throws Exception {
        if(withdraw <= this.balance + this.overdraft){
            if(withdraw <= balance) {
                setBalance(this.balance - withdraw);
            }
            else if(withdraw > this.balance && withdraw <= (this.balance + this.overdraft)){
                setOverdraft((int) (this.overdraft - (withdraw - this.balance)));
                setBalance(0F);
            }
        }
        else{
            throw new AccountInsufficientFoundsException();
        }
    }
    public Boolean checkPin(Integer pin){
        return this.pin.equals(pin);
    }
}