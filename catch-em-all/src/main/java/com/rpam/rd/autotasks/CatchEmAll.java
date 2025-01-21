package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new Exception();

    public static void riskyMethod() throws Exception {
        if (exception instanceof FileNotFoundException) {
            throw new IllegalArgumentException("Resource is missing", exception);
        } else if (exception instanceof IOException) {
            throw new IllegalArgumentException("Resource error", exception);
        } else if (exception instanceof ArithmeticException || exception instanceof NumberFormatException) {
            System.err.println(exception.getMessage());
            return;
        }
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
