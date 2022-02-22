package com.company;
import java.util.Scanner;

public class Playground_owner {
    Scanner input=new Scanner(System.in);

    private String name, email, location;
    private int ID, password, phone;
    private eWallet eWallet;

    public Playground_owner (String name,String email,String location,int ID,int password,int phone,eWallet eWallet )
    {
        this.name=name;
        this.email=email;
        this.location=location;
        this.ID=ID;
        this.password=password;
        this.phone=phone;
        this.eWallet=eWallet;
    }
    public Playground_owner( ){}
    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public void seteWallet(com.company.eWallet eWallet) {
        this.eWallet = eWallet;
    }

    public com.company.eWallet getEWallet() {
        return eWallet;
    }

    public void addPlayGround(){

        System.out.println("WHAT IS PLAYGROUND NAME?");
        String name=input.next();
        System.out.println("WHAT IS PLAYGROUND PRICE PER HOUR?");
        int price =input.nextInt();
        System.out.println("WHAT ARE PLAYGROUND AVAILABLE HOURS");
        int availableHours =input.nextInt();

        Playgrounds newPlayground= new Playgrounds(name,price,availableHours);
        System_Info.playgrounds.add(newPlayground);
        System.out.println("----------- Playground is added successfully -----------");

    }

    @Override
    public String toString() {
        return "Playground_owner{" +
                "input=" + input +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", ID=" + ID +
                ", password=" + password +
                ", phone=" + phone +
                ", eWallet=" + eWallet +
                '}';
    }
}
