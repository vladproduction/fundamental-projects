package com.epam.rd.autotasks;

import java.util.Arrays;

public class QuadraticEquation {

    public String solve(double a, double b, double c) {

        if(a == 0){
            throw new IllegalArgumentException("Parameter 'a' (first) might not be zero.");
        }

        double discriminant = b * b - 4 * a * c;
        String result;

        //format#1: x1 x2 (two roots)
        if(discriminant > 0){
            double root1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            /*double[] roots = {root1, root2};
            Arrays.sort(roots);
            result = roots[0] + " " + roots[1]; //in asc*/

            if(root1 < root2){
                result = root1 + " " + root2;
            }
            else {
                result = root2 + " " + root1;
            }

        }

        //format#2: x1 (just the value of the root)
        else if(discriminant == 0){
            double root = - b / (2 * a);
            result = String.valueOf(root);
        }

        //format#3: no roots (just a string value "no roots")
        else {
            result = "no roots";
        }

        return result;
    }


}