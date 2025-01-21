package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {
    private final int[] container;
    private int i = 0;
    private int sum = 0;
    private final int marker;
    private int decrement = 1;

    public CarouselRun(int[] container, int counter) {
        this.container = Arrays.copyOf(container, container.length);
        marker = 0;
        for (int element : container) {
            sum += element;
        }
    }

    public CarouselRun(int[] container, int counter, int marker) {
        this.container = Arrays.copyOf(container, container.length);
        this.marker = marker;
        for (int element : container) {
            sum += element;
        }
    }

    public int next() {

        int temp;

        if(isFinished()){
            return -1;
        }
        if(i == container.length){
            i = 0;
            decrement++;
        }

        while (container[i] <= 0){
            i++;
            if(i == container.length){
                i = 0;
                decrement++;
            }
        }

        if(marker == 0){
            sum--;
            return container[i++]--;
        } else if (marker == 1) {
            temp = container[i];
            container[i] /= 2;
            sum = sum - container[i] - temp % 2;
            i++;
            return temp;
        } else {
            temp = container[i];
            container[i] -= decrement;
            i++;
            return temp;
        }

    }

    public boolean isFinished() {
        if(marker == 2){
            for (int element : container) {
                if(element > 0){
                    return false;
                }
            }
            return true;
        } else {
            return sum == 0;
        }
    }

}
