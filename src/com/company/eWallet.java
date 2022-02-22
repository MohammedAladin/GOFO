package com.company;

public class eWallet {
    private int ID;
    private int balance;

    public eWallet(int ID, int balance)
    {
        this.ID=ID;
        this.balance=balance;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public int getBalance() {
        return balance;
    }
    public void deposit(int money){
        balance+=money;
    }
    public void withdraw(int money){
        if(money>balance)
            System.out.println("----------- Sorry, can't withdraw your balance is only = " +balance+ " -----------"+ "\n");
        else
        {
            balance-=money;
        }

    }
}
