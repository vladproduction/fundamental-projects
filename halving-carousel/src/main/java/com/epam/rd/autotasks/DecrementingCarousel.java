package com.epam.rd.autotasks;

public class DecrementingCarousel {

    private final int[] elements;
    private final int capacity;
    protected boolean isRunning = false;

    protected CarouselRun carousel;
    private int currentSize = 0;

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public int[] getElements() {
        return elements;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean addElement(int element) {
        if (element <= 0 || isRunning || currentSize >= capacity) {
            return false;
        }
        elements[currentSize++] = element;
        return true;
    }

    public CarouselRun run() {
        if (isRunning) {
            return null;
        }
        isRunning = true;
        carousel = new CarouselRun(this);
        return carousel;
    }

}
