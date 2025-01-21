package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private final int[] elementsContainer;
    private final int capacity;
    private byte isRunningFlag = 0;
    private int currentSize = 0;

    public DecrementingCarousel(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        elementsContainer = new int[capacity];
    }

    public byte getIsRunningFlag() {
        return isRunningFlag;
    }

    public void setIsRunningFlag(byte isRunningFlag) {
        this.isRunningFlag = isRunningFlag;
    }

    public int[] getElementsContainer() {
        return elementsContainer;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean addElement(int element) {
        if(isRunningFlag == 1 || element <= 0 || currentSize >= capacity){
            return false;
        }
        elementsContainer[currentSize] = element;
        currentSize++;
        return true;

    }

    public CarouselRun run() {
        if(isRunningFlag == 1){
            return null;
        }
        isRunningFlag = 1;
        return new CarouselRun(elementsContainer, currentSize);
    }
}
