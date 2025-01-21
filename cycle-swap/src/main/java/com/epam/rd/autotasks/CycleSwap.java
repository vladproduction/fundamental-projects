package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if(array == null || array.length <= 1){
            return;
        }
        int lastElem = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElem;
    }

    static void cycleSwap(int[] array, int shift) {
        if(array == null || array.length == 0){
            return;
        }
        int n = array.length;
        shift %= n;
        if(shift == 0){
            return;
        }
        int[] temp = new int[shift];
        for (int i = 0; i < shift; i++) {
            temp[i] = array[n - shift + i];
        }
        for (int i = n - 1; i >= shift; i--) {
            array[i] = array[i - shift];
        }
        for (int i = 0; i < shift; i++) {
            array[i] = temp[i];
        }
    }
}
