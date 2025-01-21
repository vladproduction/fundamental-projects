package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner(System.in);
        int totalBill = scanner.nextInt();
        int amountFriends = scanner.nextInt();

        if(totalBill < 0){
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        if(amountFriends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }

        int partToPay = (int)(totalBill * .1);
        totalBill += partToPay;
        System.out.println(totalBill / amountFriends);
    }
}
