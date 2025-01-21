package com.epam.rd.autotasks.maincases;

import com.epam.rd.autotasks.CarouselRun;
import com.epam.rd.autotasks.DecrementingCarousel;

public class RefusingAddingMoreElementsCase {
    public static void main(String[] args) {
        DecrementingCarousel carousel = new DecrementingCarousel(3);

        System.out.println(carousel.addElement(-2)); //false
        System.out.println(carousel.addElement(0)); //false

        System.out.println(carousel.addElement(2)); //true
        System.out.println(carousel.addElement(3)); //true
        System.out.println(carousel.addElement(1)); //true

        //carousel is full
        System.out.println(carousel.addElement(2)); //false

        CarouselRun run = carousel.run();

        System.out.println(run.next()); //2
        System.out.println(run.next()); //3
        System.out.println(run.next()); //1

        System.out.println(run.next()); //1
        System.out.println(run.next()); //2

        System.out.println(run.next()); //1

        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
