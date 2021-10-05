package com.example.springboot;

import com.example.exceptions.ATMInsufficientFundsException;
import com.example.exceptions.InvalidValueException;

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

    public ATM (){

    }

    public ATM(Integer balance, Integer bill50, Integer bill20, Integer bill10, Integer bill5) {
        this.balance = balance;
        this.bill50 = bill50;
        this.bill20 = bill20;
        this.bill10 = bill10;
        this.bill5 = bill5;
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

    public ATM withdraw(Integer withdraw) throws  Exception{
            Integer remainder = withdraw;
            ATM atm = new ATM();
            if(withdraw > this.balance){
                throw new ATMInsufficientFundsException();
            }
            else{
                if(remainder % 5 != 0){
                    throw new InvalidValueException();
                }
                else{
                    atm = calculateBills50(withdraw, atm);
                    if(atm.getBalance() != 0){
                        atm = calculateBills20(atm);
                    }
                    if(atm.getBalance() != 0){
                        atm = calculateBills10(atm);
                    }
                    if(atm.getBalance() != 0){
                        atm=calculateBills5(atm);
                    }
                }
            }
            return atm;
    }

    public ATM calculateBills50(Integer withdraw, ATM atm){
        Integer bill50 = 0;
        Integer remainder = withdraw;
        bill50 = remainder / 50;
        if(bill50.intValue() <= this.getBill50().intValue()){
            atm.setBill50(bill50);
            this.setBill50(this.getBill50() - bill50);
        }
        else{
            atm.setBill50(this.getBill50());
            this.setBill50(0);
        }

        remainder = remainder - atm.getBill50()*50;
        setBalance(this.balance - bill50*50);
        atm.setBalance(remainder);

        return atm;
    }

    public ATM calculateBills20(ATM atm){
        Integer bill20 = 0;
        Integer remainder = atm.balance;
        bill20 = remainder / 20;
        if(bill20.intValue() <= this.bill20.intValue()){
            atm.setBill20(bill20);
            this.setBill20(this.bill20 - bill20);
        }
        else{
            atm.setBill20(this.bill20);
            this.setBill20(0);
        }

        remainder = remainder - atm.getBill20()*20;
        setBalance(this.balance - bill20*20);
        atm.setBalance(remainder);

        return atm;
    }

    public ATM calculateBills10(ATM atm){
        Integer bill10 = 0;
        Integer remainder = atm.balance;
        bill10 = remainder / 10;
        if(bill10.intValue() <= this.bill10.intValue()){
            atm.setBill10(bill10);
            this.setBill10(this.bill10 - bill10);
        }
        else{
            atm.setBill10(this.bill10);
            this.setBill10(0);
        }

        remainder = remainder - atm.getBill10()*10;
        setBalance(this.balance - bill10*10);
        atm.setBalance(remainder);

        return atm;
    }

    public ATM calculateBills5(ATM atm) throws Exception {
        Integer bill5 = 0;
        Integer remainder = atm.balance;
        bill5 = remainder / 5;
        if(bill5.intValue() <= this.bill5.intValue()){
            atm.setBill5(bill5);
            this.setBill5(this.bill5 - bill5);
            remainder = remainder - atm.getBill5()*5;
            setBalance(this.balance - bill5*5);
            atm.setBalance(remainder);
        }
        else{
            throw new ATMInsufficientFundsException();
        }

        return atm;
    }





}