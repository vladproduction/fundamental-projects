package com.epam.rd.autotasks;

public class MainRegularCase {
    public static void main(String[] args) {
        DecrementingCarousel carousel = new DecrementingCarousel(7);

        carousel.addElement(2);
        carousel.addElement(3);
        carousel.addElement(1);

        CarouselRun run = carousel.run();

        System.out.println(run.isFinished()); //false

        System.out.println(run.next()); //2
        System.out.println(run.next()); //3
        System.out.println(run.next()); //1

        System.out.println(run.next()); //1
        System.out.println(run.next()); //2

        System.out.println(run.next()); //1

        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1

        //output actual:
//        false
//        2
//        1 --> ? why not 3
//        3 --> ? why not 1
//        2 --> ? wny not 1
//        1 --> ? wny not 2
//        1
//        true
//        -1

        //guess it`s some issue with add or/and next methods?
    }
}
