package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("------------- WELCOME TO GOFO PROGRAM -------------");

        int choice =0;
        while (choice!=3)
        {
            
            Playground_owner loggedInOwner;
            The_player loggedInPlayer ;
            int ownerIndex=0;
            boolean again;
            boolean isFound;
            int eWalletId;
            int eWalletBalance;
            eWallet newEWallet;

            System.out.println(
                    """
                            1- REGISTER NEW ACCOUNT
                            2- LOG IN TO YOUR ACCOUNT\s
                            3- EXIT\s""");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.println(
                            """
                                    1- OWNER REGISTER
                                    2- PLAYER REGISTER
                                    3- ADMIN REGISTER
                                    4- BACK TO MAIN MENU""");

                        int accountChoice=input.nextInt();

                        System.out.println("PLEASE ENTER YOUR NAME");
                        String name=input.next();
                        System.out.println("PLEASE, ENTER YOU NATIONALID");
                        int ID=input.nextInt();
                        System.out.println("PLEASE, ENTER YOUR LOCATION");
                        String location=input.next();
                        System.out.println("PLEASE, ENTER YOUR PHONE NUMBER");
                        int phone=input.nextInt();
                        System.out.println("PLEASE, ENTER YOUR EMAIL");
                        String email=input.next();
                        System.out.println("PLEASE, ENTER YOUR PASSWORD");
                        int pass=input.nextInt();

                        switch (accountChoice){
                            case 1:
                                for (int i=0; i<System_Info.owners.size(); i++)
                                {
                                    if (email.equals(System_Info.owners.get(i).getEmail()))
                                    {
                                        System.out.println("THIS EMAIL IS ALREADY EXISTED, PLEASE ENTER NEW ONE");
                                        email=input.next();
                                        i=-1;
                                    }
                                }
                                System.out.println("PLEASE, ENTER THE eWALLET ID : ");
                                eWalletId = input.nextInt();
                                for (int i=0; i<System_Info.owners.size(); i++)
                                {
                                    if(eWalletId==System_Info.owners.get(i).getEWallet().getID())
                                    {
                                        System.out.println("SORRY, THIS ID IS ALREADY EXISTS"+"\n"+
                                                "PLEASE ENTER NEW ONE : ");
                                        eWalletId = input.nextInt();
                                        i=-1;
                                    }
                                }
                                System.out.println("PLEASE, ENTER THE eWALLET BALANCE : ");
                                eWalletBalance = input.nextInt();
                                newEWallet=new eWallet(eWalletId,eWalletBalance);

                                Playground_owner newOwner = new Playground_owner(name,email,location,ID,pass,phone,newEWallet);
                                System_Info.owners.add(newOwner);
                                System.out.println("----------- OWNER IS SUCCESSFULLY ADDED ----------- ");
                                break;
                            case 2:
                                for (int i=0; i<System_Info.players.size(); i++)
                                {
                                    if (email.equals(System_Info.players.get(i).getEmail()))
                                    {
                                        System.out.println("THIS EMAIL IS ALREADY EXISTED, PLEASE ENTER NEW ONE");
                                        email=input.next();
                                        i=-1;
                                    }
                                }
                                System.out.println("PLEASE, ENTER THE eWALLET ID : ");
                                eWalletId = input.nextInt();
                                for (int i=0; i<System_Info.players.size(); i++)
                                {
                                    if(eWalletId==System_Info.players.get(i).getEWallet().getID())
                                    {
                                        System.out.println("SORRY, THIS ID IS ALREADY EXISTS"+"\n"+
                                                            "PLEASE ENTER NEW ONE : ");
                                        eWalletId = input.nextInt();
                                        i=-1;
                                    }
                                }
                                System.out.println("PLEASE, ENTER THE eWALLET BALANCE : ");
                                eWalletBalance = input.nextInt();
                                newEWallet=new eWallet(eWalletId,eWalletBalance);

                                The_player newPlayer = new The_player(name,email,location,ID,pass,phone,newEWallet);
                                System_Info.players.add(newPlayer);
                                System.out.println("------------ PLAYER IS SUCCESSFULLY ADDED ------------");
                                break;
                            case 3 :

                                for (int i=0; i<System_Info.administrators.size(); i++)
                                {
                                    if(System_Info.administrators.get(i).getEmail().equals(email))
                                    {
                                        System.out.println("THIS EMAIL IS ALREADY EXISTED, PLEASE ENTER NEW ONE");
                                        email=input.next();
                                        i=-1;
                                    }
                                }

                                The_administrator newAdmin = new The_administrator(name,email,location,ID,pass,phone);
                                System_Info.administrators.add(newAdmin);
                                System.out.println("------------ ADMIN IS SUCCESSFULLY ADDED ------------");
                                break;
                        }
                        break;
                case 2 :
                    int logINChoice=0;
                    while (logINChoice!=4){

                    System.out.println("""
                                    1- OWNER LOGIN
                                    2- PLAYER LOGIN
                                    3- ADMIN LOGIN
                                    4- BACK""");


                        logINChoice=input.nextInt();
                        String logINEmail="";
                        int logINPass=0;
                        switch (logINChoice) {
                            case 1:
                                if (System_Info.owners.size() > 0) {

                                    System.out.println("PLEASE, ENTER YOUR EMAIL");
                                    logINEmail = input.next();
                                    System.out.println("PLEASE, ENTER YOUR PASSWORD");
                                    logINPass = input.nextInt();
                                    isFound = false;
                                    again = true;
                                    loggedInOwner = new Playground_owner();
                                    for (int i = 0; i < System_Info.owners.size(); i++) {
                                        if (logINEmail.equals(System_Info.owners.get(i).getEmail()) && logINPass == System_Info.owners.get(i).getPassword()) {
                                            System.out.println("------------- LOGGED IN SUCCESSFULLY -------------");
                                            ownerIndex = i;
                                            isFound = true;
                                            loggedInOwner = System_Info.owners.get(ownerIndex);
                                        }
                                        if (i == System_Info.owners.size() - 1 && !isFound) {
                                            System.out.println("EITHER EMAIL OR PASSWORD IS WRONG");
                                            System.out.println("1- TRY AGAIN " + "\n"
                                                    +          "2- BACK TO MAIN MENU");
                                            int makeChoice = input.nextInt();
                                            if (makeChoice == 1) {
                                                System.out.println("PLEASE, ENTER YOUR EMAIL");
                                                logINEmail = input.next();
                                                System.out.println("PLEASE, ENTER YOUR PASSWORD");
                                                logINPass = input.nextInt();
                                                i = -1;
                                            } else
                                            {
                                               again=false;
                                            }
                                        }
                                    }
                                    if(!again)
                                    {
                                        break;
                                    }
                                    int ownerMenuChoice = 0;
                                    while (ownerMenuChoice != 6) {

                                        System.out.println("""
                                                --------- OWNER MENU ---------
                                                1- ADD NEW PLAYGROUND
                                                2- DISPLAY All PLAYGROUNDS INFORMATION
                                                3- DISPLAY All PLAYERS INFORMATION 
                                                4- CHANGE AVAILABLE HOURS FOR ANY PLAYGROUND 
                                                5- eWALLET OPERATION
                                                6- BACK""");

                                        ownerMenuChoice = input.nextInt();
                                        switch (ownerMenuChoice) {
                                            case 1:
                                                loggedInOwner.addPlayGround();
                                                break;
                                            case 2:
                                                if(System_Info.playgrounds.size()>0){
                                                    for (int i = 0; i < System_Info.playgrounds.size(); i++) {
                                                        System.out.println("PLAYGROUND " + (i + 1) + " : " + System_Info.playgrounds.get(i));
                                                    }
                                                }
                                                else
                                                    System.out.println("THERE'S NO PLAYGROUNDS.");
                                                break;
                                            case 3:
                                                if(System_Info.players.size()>0)
                                                {
                                                    for (int i = 0; i < System_Info.players.size(); i++) {
                                                        System.out.println("PLAYER " + (i + 1) + " : " + System_Info.players.get(i));
                                                    }
                                                }
                                                else
                                                {
                                                    System.out.println("THERE'S NO PLAYERS.");
                                                }
                                                break;
                                            case 4:
                                                System.out.println("ENTER PLAYGROUND NAME : ");
                                                String playgroundName = input.next();
                                                again = true;
                                                boolean isExisted = false;
                                                int playgroundsI = 0;
                                                for (int i = 0; i < System_Info.playgrounds.size(); i++) {
                                                    if (playgroundName.equals(System_Info.playgrounds.get(i).getName())) {
                                                        System.out.println("------------ PLAYGROUND IS FOUND ------------");
                                                        isExisted = true;
                                                        playgroundsI = i;
                                                    } else if (i == System_Info.playgrounds.size() && !isExisted) {
                                                        System.out.println("THIS PLAYGROUND IS NOT EXIST");
                                                        System.out.println("1- TRY AGAIN " + "\n"
                                                                         + "2- BACK TO MAIN MENU");
                                                        int makeChoice = input.nextInt();
                                                        if (makeChoice == 1) {
                                                            playgroundName = input.next();
                                                            i = -1;
                                                        }
                                                        else
                                                            again=false;
                                                    }
                                                }
                                                if (!again){
                                                    break;
                                                }
                                                System.out.println("PLEASE ENTER THE NEW AVAILABLE HOURS : ");
                                                int avHours = input.nextInt();
                                                System_Info.playgrounds.get(playgroundsI).setAvailableHours(avHours);
                                                System.out.println("THE NEW AVAILABLE HOURS = " + System_Info.playgrounds.get(playgroundsI).getAvailableHours());
                                                break;
                                            case 5:
                                                System.out.println("1- DEPOSIT" + "\n"
                                                        + "2- WITHDRAW" + "\n" +
                                                        "3- CHECK THE BALANCE");
                                                int eWalletChoice = input.nextInt();
                                                if (eWalletChoice == 1) {
                                                    System.out.println("ENTER MONEY THAT YOU WANT TO DEPOSIT");
                                                    int depositMoney = input.nextInt();
                                                    loggedInOwner.getEWallet().deposit(depositMoney);
                                                } else if (eWalletChoice == 2) {
                                                    System.out.println("ENTER MONEY THAT YOU WANT TO DEPOSIT");
                                                    int withdrawMoney = input.nextInt();
                                                    loggedInOwner.getEWallet().deposit(withdrawMoney);
                                                } else
                                                    System.out.println("CURRENT BALANCE = " + loggedInOwner.getEWallet().getBalance());

                                                break;
                                        }
                                    }
                                } else
                                    System.out.println("THERE'S NO OWNERS HAVE BEEN REGISTERED");
                                break;
                            case 2:

                                isFound = false;
                                again=true;
                                int playerI = 0;
                                loggedInPlayer = new The_player();
                                if (System_Info.players.size() > 0) {
                                    System.out.println("PLEASE, ENTER YOUR EMAIL");
                                    logINEmail = input.next();
                                    System.out.println("PLEASE, ENTER YOUR PASSWORD");
                                    logINPass = input.nextInt();
                                    for (int i = 0; i < System_Info.players.size(); i++) {
                                        if (logINEmail.equals(System_Info.players.get(i).getEmail()) && logINPass == System_Info.players.get(i).getPassword()) {
                                            System.out.println("------------- PLAYER LOGGED IN SUCCESSFULLY -------------");
                                            playerI = i;
                                            isFound = true;
                                            loggedInPlayer = System_Info.players.get(playerI);
                                        }
                                        if (i == System_Info.players.size() - 1 && !isFound) {
                                            System.out.println("EITHER EMAIL OR PASSWORD IS WRONG.");
                                            System.out.println("1- TRY AGAIN " + "\n"
                                                    + "2- BACK TO MAIN MENU");
                                            int makeChoice = input.nextInt();
                                            if (makeChoice == 1) {
                                                System.out.println("PLEASE, ENTER YOUR EMAIL");
                                                logINEmail = input.next();
                                                System.out.println("PLEASE, ENTER YOUR PASSWORD");
                                                logINPass = input.nextInt();
                                                i = -1;
                                            }  else
                                            {
                                                again=false;
                                            }
                                        }
                                    }
                                    if(!again)
                                    {
                                        break;
                                    }
                                    int playerMenuChoice = 0;
                                    while (playerMenuChoice != 5) {

                                        System.out.println("""
                                                --------- PLAYER MENU ---------
                                                1- BOOK PLAYGROUND
                                                2- CHECK THE eWALLET
                                                3- RATE PLAYGROUND
                                                4- CANCEL BOOKING
                                                5- BACK""");

                                        playerMenuChoice = input.nextInt();
                                        switch (playerMenuChoice) {
                                            case 1:
                                                int playgroundOperationsOfPlayer = 0;
                                                while (playgroundOperationsOfPlayer != 3) {
                                                    System.out.println("""
                                                            --------- PLAYGROUND OPERATIONS OF PLAYER ---------
                                                                                                            
                                                             1- CHECK AVAILABLE PLAYGROUND ONLY
                                                             2- BOOK
                                                             3- BACK""");

                                                    playgroundOperationsOfPlayer = input.nextInt();
                                                    switch (playgroundOperationsOfPlayer) {
                                                        case 1:
                                                            for (int i = 0; i < System_Info.playgrounds.size(); i++) {
                                                                if (System_Info.playgrounds.get(i).isAvailable)
                                                                    System.out.println("PLAYGROUND " + (i + 1) + " : " + System_Info.playgrounds.get(i));
                                                            }
                                                            break;
                                                        case 2:
                                                            for (int i = 0; i < System_Info.playgrounds.size(); i++) {
                                                                System.out.println("PLAYGROUND " + (i + 1) + " : " + System_Info.playgrounds.get(i));
                                                            }
                                                            if (System_Info.playgrounds.size() > 0) {

                                                                System.out.println("--------- WHICH ONE DO YOU WANT TO BOOK? ---------");
                                                                int playgroundIndexToBeBooked = input.nextInt();
                                                                Playgrounds PlaygroundToBeBooked = System_Info.playgrounds.get((playgroundIndexToBeBooked - 1));
                                                                if (PlaygroundToBeBooked.isAvailable && !PlaygroundToBeBooked.isBooked) {

                                                                    System.out.println(PlaygroundToBeBooked);
                                                                    System.out.println("HOW MANY HOURS? ");
                                                                    int hoursToBeBooked = input.nextInt();
                                                                    if (hoursToBeBooked > PlaygroundToBeBooked.getAvailableHours()) {
                                                                        System.out.println("SORRY, THIS PLAYGROUND IS ONLY AVAILABLE FOR " + PlaygroundToBeBooked.getAvailableHours() + " HOURS");

                                                                    } else {

                                                                        PlaygroundToBeBooked.setAvailableHours(PlaygroundToBeBooked.getAvailableHours() - hoursToBeBooked);
                                                                        int totalPrice = hoursToBeBooked * PlaygroundToBeBooked.getPricePerHour();
                                                                        System.out.println("TOTAL PRICE = " + totalPrice);
                                                                        if (totalPrice > loggedInPlayer.getEWallet().getBalance()) {
                                                                            System.out.println("SORRY YOUR BALANCE IS NOT ENOUGH");
                                                                            System.out.println("YOU CAN TRY TO DEPOSIT AND TRY AGAIN");
                                                                        }
                                                                        else
                                                                        {
                                                                            loggedInPlayer.getEWallet().withdraw(totalPrice);
                                                                            System_Info.owners.get(ownerIndex).getEWallet().deposit(totalPrice);

                                                                            System.out.println("---------- PLAYGROUND IS SUCCESSFULLY BOOKED ----------");
                                                                            PlaygroundToBeBooked.isBooked = true;
                                                                        }
                                                                    }
                                                                } else {
                                                                    System.out.println("---------- SORRY, THIS PLAYGROUND IS BOOKED OR NOT AVAILABLE FROM ADMIN ----------");
                                                                }
                                                            } else
                                                                System.out.println("THERE'S NO PLAYGROUNDS NOW");
                                                            break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                int eWalletChecker = 0;
                                                while (eWalletChecker != 4) {
                                                    System.out.println("""
                                                            --------- EWALLET CHECKER ---------
                                                                                                            
                                                             1- CHECK THE BALANCE.
                                                             2- DEPOSIT
                                                             3- WITHDRAW
                                                             4- BACK""");
                                                    eWalletChecker = input.nextInt();
                                                    switch (eWalletChecker) {
                                                        case 1:
                                                            System.out.println("YOUR BALANCE IS = " + loggedInPlayer.getEWallet().getBalance());
                                                            break;
                                                        case 2:
                                                            System.out.println("HOW MUCH MONEY DO YOU WANT TO DEPOSIT");

                                                            int depositMoney = input.nextInt();
                                                            loggedInPlayer.getEWallet().deposit(depositMoney);
                                                            break;
                                                        case 3:
                                                            System.out.println("HOW MUCH MONEY DO YOU WANT TO WITHDRAW");

                                                            int withdrawMoney = input.nextInt();
                                                            loggedInPlayer.getEWallet().withdraw(withdrawMoney);
                                                            break;
                                                    }
                                                }
                                                break;
                                            case 3:
                                                System.out.println("WHICH PLAYGROUND DO YOU WANT TO RATE");
                                                String ratedPlayground = input.next();
                                                isFound = false;
                                                for(int i=0; i<System_Info.playgrounds.size(); i++){
                                                    if(System_Info.playgrounds.get(i).getName().equals(ratedPlayground)){
                                                        System.out.println("BAD , GOOD, VERY GOOD, EXCELLENT");
                                                        String rate = input.next();
                                                        System_Info.playgrounds.get(i).setRatings(rate);
                                                        isFound=true;
                                                    }
                                                }
                                                if(!isFound){
                                                    System.out.println("YOU ENTERED WRONG NAME!");
                                                }
                                                break;
                                            case 4:
                                                System.out.println("ENTER PLAYGROUND NAME");
                                                String cancelledPlayground = input.next();
                                                isFound = false;
                                                for(int i=0; i<System_Info.playgrounds.size(); i++){
                                                    if(System_Info.playgrounds.get(i).getName().equals(cancelledPlayground)&&System_Info.playgrounds.get(i).isBooked){
                                                        System_Info.playgrounds.get(i).setBooked(false);
                                                        System.out.println("HOW MANY HOURS DID YOU RESERVE IT?");
                                                        int reserveHours=input.nextInt();
                                                        int halfMoney = reserveHours*System_Info.playgrounds.get(i).getPricePerHour();
                                                        System_Info.owners.get(ownerIndex).getEWallet().withdraw(halfMoney);
                                                        loggedInPlayer.getEWallet().deposit(halfMoney);
                                                        System.out.println("--------- RESERVATION IS CANCELLED SUCCESSFULLY --------");
                                                        isFound=true;

                                                        break;
                                                    }
                                                }
                                                if(!isFound){
                                                    System.out.println("YOU ENTERED WRONG NAME!, OR THIS PLAYGROUND IS NOT BOOKED");
                                                }
                                                break;
                                        }
                                    }
                                } else
                                    System.out.println("THERE'S NO PLAYERS HAVE BEEN REGISTERED");

                                break;

                            case 3:
                                if (System_Info.administrators.size() > 0) {
                                    System.out.println("PLEASE, ENTER YOUR EMAIL");
                                    logINEmail = input.next();
                                    System.out.println("PLEASE, ENTER YOUR PASSWORD");
                                    logINPass = input.nextInt();
                                isFound = false;
                                again=true;
                                for (int i = 0; i < System_Info.administrators.size(); i++) {
                                    if (logINEmail.equals(System_Info.administrators.get(i).getEmail()) && logINPass == System_Info.administrators.get(i).getPassword()) {
                                        System.out.println("--------- ADMIN IS LOGGED IN SUCCESSFULLY ---------");
                                        isFound = true;
                                    }
                                    if (i == System_Info.administrators.size() - 1 && !isFound) {
                                        System.out.println("EITHER EMAIL OR PASSWORD IS WRONG");

                                        System.out.println("1- TRY AGAIN " + "\n"
                                                + "2- BACK TO MAIN MENU");
                                        int makeChoice = input.nextInt();
                                        if (makeChoice == 1) {
                                            System.out.println("PLEASE, ENTER YOUR EMAIL");
                                            logINEmail = input.next();
                                            System.out.println("PLEASE, ENTER YOUR PASSWORD");
                                            logINPass = input.nextInt();
                                            i = -1;
                                        }
                                        else
                                            again=false;

                                    }
                                }
                                    if(!again)
                                        break;

                                int adminMenuChoice = 0;
                                while (adminMenuChoice != 4) {
                                    System.out.println("""
                                            --------- Admin menu ---------
                                            1- ACTIVE PLAYGROUND
                                            2- DELETE PLAYGROUND
                                            3- CHECK RATINGS
                                            4- BACK""");

                                    adminMenuChoice = input.nextInt();
                                    switch (adminMenuChoice) {
                                        case 1:
                                            System.out.println("ENTER PLAYGROUND NAME : ");
                                            String playgroundNameToBeAvailable = input.next();
                                            isFound = false;
                                            for (int i = 0; i < System_Info.playgrounds.size(); i++) {
                                                if (playgroundNameToBeAvailable.equals(System_Info.playgrounds.get(i).getName())) {
                                                    System_Info.playgrounds.get(i).setAvailable(true);
                                                    System.out.println("-------- PLAYGROUND IS NOW AVAILABLE --------");
                                                    isFound = true;

                                                } else if (i == System_Info.playgrounds.size() && !isFound) {
                                                    System.out.println("YOU ENTERED WRONG NAME!");
                                                    System.out.println("1- ENTER NAME AGAIN : "+ "\n"
                                                                      +"2- BACK TO MENU");
                                                    int backChoice=input.nextInt();
                                                    if(backChoice==1)
                                                    {
                                                        System.out.println("ENTER PLAYGROUND NAME : ");
                                                        playgroundNameToBeAvailable = input.next();
                                                        i = -1;
                                                    }
                                                    else
                                                        break;
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("ENTER PLAYGROUND NAME : ");
                                            String playgroundToBeDeleted = input.next();
                                            isFound = false;
                                            again = true;
                                            for (int i = 0; i < System_Info.playgrounds.size(); i++) {
                                                if (playgroundToBeDeleted.equals(System_Info.playgrounds.get(i).getName())) {
                                                    System_Info.playgrounds.remove(i);
                                                    System.out.println("------------- PLAYGROUND IS SUCCESSFULLY DELETED -------------");
                                                    isFound = true;
                                                } else if (i == System_Info.playgrounds.size() && !isFound) {
                                                    System.out.println("YOU ENTERED WRONG NAME!");
                                                    System.out.println("1- ENTER NAME AGAIN : "+ "\n"
                                                                      +"2- BACK TO MENU");
                                                    int backChoice=input.nextInt();
                                                    if(backChoice==1)
                                                    {
                                                        System.out.println("ENTER PLAYGROUND NAME : ");
                                                        playgroundToBeDeleted = input.next();
                                                        i = -1;
                                                    }
                                                    else
                                                      break;
                                                }
                                            }
                                            break;
                                        case 3:
                                        for(int i=0; i<System_Info.playgrounds.size(); i++){
                                            for (int j=0; j<System_Info.playgrounds.get(i).getRate().size(); j++)
                                            System.out.println("PLAYGROUND " + (i + 1) + " : " + System_Info.playgrounds.get(i).getRate().get(j));
                                        }
                                            break;
                                    }
                                }
                        }
                                else
                                    System.out.println("----------- THERE'S NO ADMINS HAVE BEEN REGISTERED -----------");
                                break;

                        }
                    }

                    break;

            }

            }


        }


    }

