package com.epam.rd.autotasks;

/**
 * In this exercise you need to extend DecrementingCarousel. You need to implement GraduallyDecreasingCarousel.
 * This subclass must decrement elements by gradually increasing decrement.
 * When you need to decrement an element for the first time, decrease it by 1.
 * Next time you need to decrement the same element, decrease it by 2. Next time decrease by 3, then by 4 and so on.
 * Remember that you must not make process non-positive elements.
 * */
public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run() {
        if(getIsRunningFlag() == 1){
            return null;
        }
        setIsRunningFlag((byte) 1);
        return new CarouselRun(getElementsContainer(), getCurrentSize(), 2);
    }
}
