package com.epam.rd.autotasks;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Battleship8x8 b = new Battleship8x8(-1150950973573693440L);
        List<String> shots = List.of("A1", "B2", "C3", "D4");
        for(String shot: shots){
            b.shoot(shot);
        }
        String state = b.state();
        System.out.println(state);
    }
}
