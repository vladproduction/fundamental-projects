package com.epam.rd.autotasks;

public class DecrementingCarousel {

    private final int[] elementsContainer;
    private boolean isRunningState = false;
    private int currentSize = 0;
    private final int capacity;

    public DecrementingCarousel(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        elementsContainer = new int[capacity];
    }

    public boolean isRunningState(){
        return isRunningState;
    }

    public void setIsRunningState(boolean isRunningState) {
        this.isRunningState = isRunningState;
    }

    public int[] getElementsContainer() {
        return elementsContainer;
    }

    public boolean addElement(int element){
        if(isRunningState || element <= 0 || currentSize >= capacity){
            return false;
        }
        elementsContainer[currentSize] = element;
        currentSize++;
        return true;
    }

    public CarouselRun run(){
        if(isRunningState){
            return null;
        }
        isRunningState = true;
        return new CarouselRun(elementsContainer);
    }
}
