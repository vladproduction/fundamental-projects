package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int piecesOfOnePizza = scanner.nextInt();

        if (people > 0 && piecesOfOnePizza > 0) {
            int pizzasNeeded = people / piecesOfOnePizza;
            if (people % piecesOfOnePizza != 0) {
                pizzasNeeded++;
            }
            while ((pizzasNeeded * piecesOfOnePizza) % people != 0) {
                pizzasNeeded++;
            }
            System.out.println(pizzasNeeded);
        }
    }
}
