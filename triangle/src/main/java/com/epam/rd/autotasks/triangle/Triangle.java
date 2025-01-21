package com.epam.rd.autotasks.triangle;

class Triangle {

    private Point aPoint;
    private Point bPoint;
    private Point cPoint;

    public Triangle(Point aPoint, Point bPoint, Point cPoint) {
        if (isDegenerative(aPoint, bPoint, cPoint)) {
            throw new IllegalArgumentException();
        }
        this.aPoint = aPoint;
        this.bPoint = bPoint;
        this.cPoint = cPoint;
    }

    public double area() {
        return Math.abs(
                aPoint.getX() * (bPoint.getY() - cPoint.getY()) +
                bPoint.getX() * (cPoint.getY() - aPoint.getY()) +
                cPoint.getX() * (aPoint.getY() - bPoint.getY()) ) / 2;
    }

    public Point centroid() {
        double centX = ( aPoint.getX() + bPoint.getX() + cPoint.getX() ) / 3;
        double centY = ( aPoint.getY() + bPoint.getY() + cPoint.getY() ) / 3;
        return new Point(centX, centY);
    }

    private boolean isDegenerative(Point a, Point b, Point c) {
        double area = (
                a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY()) ) / 2;
        return area == 0.0;
    }

}
