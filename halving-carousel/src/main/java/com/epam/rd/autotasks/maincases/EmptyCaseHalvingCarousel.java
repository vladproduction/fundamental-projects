package com.epam.rd.autotasks.maincases;

import com.epam.rd.autotasks.CarouselRun;
import com.epam.rd.autotasks.HalvingCarousel;

public class EmptyCaseHalvingCarousel {
    public static void main(String[] args) {
        CarouselRun run = new HalvingCarousel(7).run();
        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
