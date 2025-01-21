package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {
    private final int[] containerElements;
    private int i = 0, j = 0;
    private int sum = 0;
    private final int marker;
    private int decrement = 1;
    private int actionLimit;

    public CarouselRun(int[] containerElements){
        this.containerElements = Arrays.copyOf(containerElements, containerElements.length);
        marker = 0;
        for (int element : containerElements) {
            sum += element;
        }
    }

    public CarouselRun(int[] containerElements, int marker){
        this.containerElements = Arrays.copyOf(containerElements, containerElements.length);
        this.marker = marker;
        for (int element : containerElements) {
            sum += element;
        }
    }

    public CarouselRun(int[] containerElements, int marker, int actionLimit){
        this.containerElements = Arrays.copyOf(containerElements, containerElements.length);
        this.marker = marker;
        this.actionLimit = actionLimit;
        for (int element : containerElements) {
            sum += element;
        }
    }

    public int next() {
        int temp;
        if(isFinished()){
            return -1;
        }

        if(i == containerElements.length){
            i = 0;
            decrement++;
        }

        while (containerElements[i] <= 0){
            i++;
            if(i == containerElements.length){
                i = 0;
                decrement++;
            }
        }

        if(marker == 0){
            sum--;
            return containerElements[i++]--;
        } else if (marker == 1) {
            temp = containerElements[i];
            containerElements[i] /= 2;
            sum = sum - containerElements[i] - temp % 2;
            i++;
            return temp;
        } else if (marker == 2) {
            temp = containerElements[i];
            containerElements[i] -= decrement;
            i++;
            return temp;
        } else {
            sum--;
            j++;
            return containerElements[i++]--;
        }
    }

    public boolean isFinished() {
        if(marker == 2){
            for (int element : containerElements) {
                if(element > 0){
                    return false;
                }
            }
            return true;
        } else if (marker == 3 && j == actionLimit) {
            return true;
        } else {
            return sum == 0;
        }
    }

}
