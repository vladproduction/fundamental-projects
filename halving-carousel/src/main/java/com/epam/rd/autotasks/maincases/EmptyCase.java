package com.epam.rd.autotasks.maincases;

import com.epam.rd.autotasks.CarouselRun;
import com.epam.rd.autotasks.DecrementingCarousel;

public class EmptyCase {
    public static void main(String[] args) {
        CarouselRun run = new DecrementingCarousel(7).run();
        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
