package com.epam.rd.autotasks;

public class MainEmptyCase {
    public static void main(String[] args) {
        CarouselRun run = new DecrementingCarousel(7).run();
        System.out.println(run.isFinished()); //true
        System.out.println(run.next()); //-1
    }
}
