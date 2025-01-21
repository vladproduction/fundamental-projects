package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private Point startPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {

        if(startPoint.getX() == endPoint.getX() && startPoint.getY() == endPoint.getY()){
            throw new IllegalArgumentException();
        }

        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    double length() {
        double a = endPoint.getX() - startPoint.getX();
        double b = endPoint.getY() - startPoint.getY();
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    Point middle() {
        double midX = (startPoint.getX() + endPoint.getX()) / 2;
        double midY = (startPoint.getY() + endPoint.getY()) / 2;
        return new Point(midX, midY);
    }

    Point intersection(Segment another) {
        double x1 = startPoint.getX();
        double y1 = startPoint.getY();
        double x2 = endPoint.getX();
        double y2 = endPoint.getY();
        double x3 = another.startPoint.getX();
        double y3 = another.startPoint.getY();
        double x4 = another.endPoint.getX();
        double y4 = another.endPoint.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if(denominator == 0){
            return null;
        }

        double b = ( (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4) ) / denominator;
        double c = -( (x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3) ) / denominator;

        if(b >= 0 && b <= 1 && c >= 0 && c <= 1){

            double intersectionX = x1 + b * (x2 - x1);
            double intersectionY = y1 + b * (y2 - y1);
            return new Point(intersectionX, intersectionY);
        }

        return null;
    }

}

















