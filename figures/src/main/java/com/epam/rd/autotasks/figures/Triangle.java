package com.epam.rd.autotasks.figures;

public class Triangle extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = (distance(a, b) + distance(b, c) + distance(c, a)) / 2; // semi-perimeter
        double area = Math.sqrt(s * (s - distance(a, b)) * (s - distance(b, c)) * (s - distance(c, a)));
        return area;
    }

    @Override
    public String pointsToString() {

        return    "(" + a.getX() + "," + a.getY() + ")"
                + "(" + b.getX() + "," + b.getY() + ")"
                + "(" + c.getX() + "," + c.getY() + ")";
    }

    public String toString() {
        return "Triangle[" + this.pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Point leftmost = a;

        if (b.getX() < leftmost.getX()) {
            leftmost = b;
        }
        if (c.getX() < leftmost.getX()) {
            leftmost = c;
        }

        return leftmost;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
