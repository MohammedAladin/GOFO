package com.company;

public class The_administrator {
    private String name, email, location;
    private int ID, password, phone;

    public The_administrator (String name,String email,String location,int ID,int password,int phone )
    {
        this.name=name;
        this.email=email;
        this.location=location;
        this.ID=ID;
        this.password=password;
        this.phone=phone;
    }

    public String getEmail()
    {
        return email;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "The_player{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", ID=" + ID +
                ", password=" + password +
                ", phone=" + phone +
                '}';
    }

}
