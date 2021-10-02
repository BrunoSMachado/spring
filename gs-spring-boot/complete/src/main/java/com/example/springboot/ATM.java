package com.example.springboot;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ATM {

    private @Id @GeneratedValue Long id;
    private Integer balance;
    private Integer bill50;
    private Integer bill20;
    private Integer bill10;
    private Integer bill5;
    private HashMap<Integer, Account> accounts;

    public ATM (){

    }

    public ATM(Long id, Integer balance, Integer bill50, Integer bill20, Integer bill10, Integer bill5) {
        this.balance = balance;
        this.bill50 = bill50;
        this.bill20 = bill20;
        this.bill10 = bill10;
        this.bill5 = bill5;
        this.accounts = new HashMap<Integer, Account>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ATM atm = (ATM) object;
        return id.equals(atm.id) && balance.equals(atm.balance) && bill50.equals(atm.bill50) && bill20.equals(atm.bill20) && bill10.equals(atm.bill10) && bill5.equals(atm.bill5);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ATM{" +
                "id=" + id +
                ", balance=" + balance +
                ", bill50=" + bill50 +
                ", bill20=" + bill20 +
                ", bill10=" + bill10 +
                ", bill5=" + bill5 +
                '}';
    }
}