package com.epam.rd.autotasks;

import java.util.HashMap;
import java.util.Map;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        //System.out.println("----shipsTable-----");
        byte[][] shipsTable = toTable(ships);
        //System.out.println("----shotsTable-----");
        byte[][] shotsTable = null;
        if (shots == 0) {
            shotsTable = new byte[8][8];
        } else {
            shotsTable = toTable(shots);
        }
        //split "A1" into [x][y]
        char firstCharacter = shot.charAt(0);//A
        char secondCharacter = shot.charAt(1);//1
        int letterCoordinate = transformLetterCoordinate(firstCharacter)-1;//we use 1 for shot, but index in array starts from 0
        int numberCoordinate = Integer.parseInt(String.valueOf(secondCharacter))-1;//we use 1 for shot, but index in array starts from 0

        //mark shot in the shot table
        shotsTable[numberCoordinate][letterCoordinate] = 1;
        //now we need to save the latest state of the shot table, but this state must be represented as long
        //for this purpose we have a method to convert byte[][] into Long
        long updatedShots = fromTable(shotsTable);
        shots = updatedShots;

        return shipsTable[numberCoordinate][letterCoordinate] == 1;
    }

    public String state() {
        byte[][] shipsTable = toTable(ships);
        byte[][] shotsTable = toTable(shots);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<shipsTable.length;i++){
            byte[] shipRow = shipsTable[i];
            byte[] shotRow = shotsTable[i];
            String[] resultRow = new String[shipRow.length];
            for(int j=0;j<shipRow.length;j++){
                //if we have ship here
                if(shipRow[j]==1){
                    //if we have shot here
                    if(shotRow[j]==1){
                        resultRow[j] = "☒";
                    }else{
                        resultRow[j] = "☐";
                    }
                }else{
                    //if we have shot here
                    if(shotRow[j]==1){
                        resultRow[j] = "×";
                    }else{
                        resultRow[j] = ".";
                    }
                }
            }
            String resultLine = makeResultLine(resultRow);

            //not to add new line for the last line
            if (i != shipsTable.length - 1) {
                resultLine += "\n";
            }
            result.append(resultLine);

        }
        return result.toString();
    }

    private String makeResultLine(String[] resultRow) {
        String resultLine = "";
        for (String item : resultRow) {
            resultLine += item;
        }
        return resultLine;
    }


    private byte[][] toTable(long value){
        byte[][] table = new byte[8][8];

        // Fill the byte array with bits from the long value
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Calculate the bit position (63 is the most significant bit)
                int bitPosition = 63 - (i * 8 + j);
                // Extract the bit and store it as a byte (0 or 1)
                table[i][j] = (byte) ((value >> bitPosition) & 1);
            }
        }
        return table;
    }

    private byte[][] toTableOld(long value) {
        String str = Long.toBinaryString(value);
        byte[][] data = new byte[8][8];
        int indexOfStr = 0;
        for (int i = 0; i < data.length; i++) {
            byte[] item = data[i];
            for (int j = 0; j < item.length; j++) {
                data[i][j] = Byte.parseByte(String.valueOf(str.charAt(indexOfStr++)));
            }
        }
        /*for (byte[] item : data) {
            System.out.println(Arrays.toString(item));
        }*/
        return data;
    }

    private long fromTable(byte[][] table) {
       /* StringBuilder sb = new StringBuilder();
        for (byte[] row : table) {
            for(byte i: row) {
                sb.append(i);
            }
        }
        return Long.parseLong(sb.toString(), 2);*/

        long result = 0L;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Shift the current result by 1 to the left to make space for the new bit
                result <<= 1;
                // Add the current byte value (0 or 1) as the least significant bit
                result |= table[i][j];
            }
        }
        return result;
    }

    private int transformLetterCoordinate(char letterCoordinate){
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('A', 1);
        map.put('b', 2);
        map.put('B', 2);
        map.put('c', 3);
        map.put('C', 3);
        map.put('d', 4);
        map.put('D', 4);
        map.put('e', 5);
        map.put('E', 5);
        map.put('f', 6);
        map.put('F', 6);
        map.put('g', 7);
        map.put('G', 7);
        map.put('h', 8);
        map.put('H', 8);
        return map.get(letterCoordinate);
    }
}
