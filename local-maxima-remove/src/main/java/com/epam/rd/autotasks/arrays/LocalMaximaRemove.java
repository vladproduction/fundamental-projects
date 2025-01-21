package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        if(array == null){
            throw new UnsupportedOperationException();
        }
        if(array.length < 2){
            throw new UnsupportedOperationException();
        }
        List<Integer> copyListIntoArray = new ArrayList<>();
        //first element check:
        if(array[0] <= array[1]){
            copyListIntoArray.add(array[0]);
        }
        //start from 1 till end-1 check if neighbours are greater or equals than current element
        for (int i = 1; i < array.length - 1; i++) {
            if(array[i] <= array[i - 1] || array[i] <= array[i + 1]){ //previous element (left) or next element (right) could be greater
                copyListIntoArray.add(array[i]); // if not add current to the result list
            }
        }
        //last element check:
        if(array[array.length - 1] <= array[array.length - 2]){//if the last one is less then previous
            copyListIntoArray.add(array[array.length - 1]); //then add it (last elem) to the result list
        }
        //convert list back to the array for the method result return
        int[] result = copyListIntoArray.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
