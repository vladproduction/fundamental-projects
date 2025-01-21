package com.epam.rd.autotasks.maincases;

import com.epam.rd.autotasks.CarouselRun;
import com.epam.rd.autotasks.GraduallyDecreasingCarousel;

public class EmptyCaseGraduallyDecreasingCarousel {
    public static void main(String[] args) {
        CarouselRun run = new GraduallyDecreasingCarousel(7).run();
        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
