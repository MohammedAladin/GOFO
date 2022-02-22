package com.company;

public class The_player {

    private String name, email, location;
    private int ID, password, phone;
    private eWallet eWallet;
    public The_player (String name,String email,String location,int ID,int password,int phone, eWallet eWallet )
    {
        this.name=name;
        this.email=email;
        this.location=location;
        this.ID=ID;
        this.password=password;
        this.phone=phone;
        this.eWallet=eWallet;
    }
    public The_player(){}

    public int getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public void seteWallet(com.company.eWallet eWallet) {
        this.eWallet = eWallet;
    }

    public com.company.eWallet getEWallet() {
        return eWallet;
    }

    @Override
    public String toString() {
        return "[" +
                "NAME = '" + name + '\'' +
                ", EMAIL = '" + email + '\'' +
                ", LOCATION = '" + location + '\'' +
                ", ID = " + ID +
                ", PASSWORD = " + password +
                ", PHONE = " + phone +
                ", eWALLET = " + eWallet +
                ']';
    }
}
