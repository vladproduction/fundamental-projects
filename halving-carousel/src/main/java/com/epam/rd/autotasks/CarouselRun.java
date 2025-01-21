package com.epam.rd.autotasks;

public class CarouselRun {

    protected DecrementingCarousel carousel;
    protected int index = 0;

    public CarouselRun(DecrementingCarousel carousel) {
        this.carousel = carousel;
    }

    public int next() {
        while (!isFinished()) {
            if (index == carousel.getElements().length) {
                index = 0;
            }
            int currentValue = carousel.getElements()[index];
            if (currentValue > 0) {
                carousel.getElements()[index++]--;
                return currentValue;
            }
            index++;
        }
        return -1;
    }

    public boolean isFinished() {
        for (int i = 0; i < carousel.getCurrentSize(); i++) {
            if (carousel.getElements()[i] > 0) {
                return false;
            }
        }
        return true;
    }

}
