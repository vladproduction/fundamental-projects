package com.epam.rd.autotasks.figures;

public class Quadrilateral extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(final Point a,final Point b,final Point c,final Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        double s1 = (distance(a, b) + distance(b, c) + distance(a, c)) / 2;
        double area1 = Math.sqrt(s1 * (s1 - distance(a, b)) * (s1 - distance(b, c)) * (s1 - distance(a, c)));

        double s2 = (distance(a, c) + distance(c, d) + distance(a, d)) / 2;
        double area2 = Math.sqrt(s2 * (s2 - distance(a, c)) * (s2 - distance(c, d)) * (s2 - distance(a, d)));

        return area1 + area2;
    }

    @Override
    public String pointsToString() {
        return    "(" + a.getX() + "," + a.getY() + ")"
                + "(" + b.getX() + "," + b.getY() + ")"
                + "(" + c.getX() + "," + c.getY() + ")"
                + "(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + this.pointsToString() + "]";
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
        if (d.getX() < leftmost.getX()) {
            leftmost = d;
        }
        return leftmost;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}


