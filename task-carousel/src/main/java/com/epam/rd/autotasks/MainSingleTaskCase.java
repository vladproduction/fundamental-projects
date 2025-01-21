package com.epam.rd.autotasks;

public class MainSingleTaskCase {
    public static void main(String[] args) {
        TaskCarousel carousel = new TaskCarousel(4);

        System.out.println(carousel.isEmpty()); //true
        System.out.println(carousel.isFull()); //false
        System.out.println(carousel.execute()); //false

        CountDownTask task = new CountDownTask(2);
        System.out.println(carousel.addTask(task)); //true+

        System.out.println(carousel.isEmpty()); //false
        System.out.println(carousel.isFull()); // false

        System.out.println(task.getValue()); //2
        System.out.println(carousel.execute()); //true+
        System.out.println(task.getValue()); //1
        System.out.println(carousel.execute()); //true
        System.out.println(task.getValue()); //0

        System.out.println(carousel.execute()); //false
        System.out.println(carousel.isEmpty()); //true+

    }
}
