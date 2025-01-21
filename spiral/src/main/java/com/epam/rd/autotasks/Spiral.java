package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        //init two-dim array to be returned
        int[][] result = new int[rows][columns];

        //defining boundaries
        int top = 0;
        int left = 0;
        int bottom = rows - 1;
        int right = columns - 1;

        //define start position
        int number = 1;

        //using while loop to moving and fill positions by numbers sequence
        while (top <= bottom && left <= right){

            //1) filling top row from start position (left) to right
            for (int i = left; i <= right; i++) {
                result[top][i] = number++;
            }
            top++; //move top boundary down

            //2) filling right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = number++;
            }
            right--; //move right boundary left

            //3) if available filling bottom row from right to left
            if(top <= bottom){
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = number++;
                }
                bottom--; // move bottom boundary up
            }

            //4) if available filling left column from bottom to top
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = number++;
                }
                left++; // move left boundary right
            }

        }

        return result;
    }
}
