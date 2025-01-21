package com.epam.rd.autotasks;

public class HalvingCarouselRun extends CarouselRun{

    public HalvingCarouselRun(HalvingCarousel carousel) {
        super(carousel);
    }

    @Override
    public int next() {
        while (!isFinished()){
            if(index == carousel.getElements().length){
                index = 0;
            }
            int currentHalveValue = carousel.getElements()[index];
            if(currentHalveValue > 0){
                int result = currentHalveValue / 2;
                carousel.getElements()[index++] = result;
                return currentHalveValue;
            }
            index++;
        }
        return -1;
    }

}
