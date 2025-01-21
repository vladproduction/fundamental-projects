package com.epam.rd.autotasks.maincases;

import com.epam.rd.autotasks.DecrementingCarousel;

public class RefuseAddWhenRunCalled {
    public static void main(String[] args) {
        DecrementingCarousel carousel = new DecrementingCarousel(10);

        System.out.println(carousel.addElement(2)); //true
        System.out.println(carousel.addElement(3)); //true
        System.out.println(carousel.addElement(1)); //true

        carousel.run();

        System.out.println(carousel.addElement(2)); //false
        System.out.println(carousel.addElement(3)); //false
        System.out.println(carousel.addElement(1)); //false
    }
}
