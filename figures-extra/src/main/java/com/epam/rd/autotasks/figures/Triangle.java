package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;

    private static final double EPSILON = 1e-10; // Tolerance for double comparisons

    public Triangle(final Point a, final Point b, final Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Points cannot be null.");
        }

        this.a = a;
        this.b = b;
        this.c = c;

        // Check for degeneracy
        if (isDegenerative(a, b, c)) {
            throw new IllegalArgumentException("Degenerate triangle: points are collinear.");
        }
    }

    private boolean isDegenerative(Point p1, Point p2, Point p3) {
        // Calculate the area using the determinant method
        return Math.abs(p1.getX() * (p2.getY() - p3.getY()) +
                p2.getX() * (p3.getY() - p1.getY()) +
                p3.getX() * (p1.getY() - p2.getY())) < EPSILON; // Use EPSILON for comparison
    }

    @Override
    public Point centroid() {
        double centroidX = (a.getX() + b.getX() + c.getX()) / 3;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(centroidX, centroidY);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Triangle) {
            Triangle other = (Triangle) figure;
            Point[] thisVertices = {this.a, this.b, this.c};
            Point[] otherVertices = {other.a, other.b, other.c};

            // Sort and compare vertices
            Arrays.sort(thisVertices, (p1, p2) -> {
                int cmp = Double.compare(p1.getX(), p2.getX());
                return (cmp == 0) ? Double.compare(p1.getY(), p2.getY()) : cmp;
            });
            Arrays.sort(otherVertices, (p1, p2) -> {
                int cmp = Double.compare(p1.getX(), p2.getX());
                return (cmp == 0) ? Double.compare(p1.getY(), p2.getY()) : cmp;
            });

            // Use the EPSILON for comparisons
            for (int i = 0; i < thisVertices.length; i++) {
                if (Math.abs(thisVertices[i].getX() - otherVertices[i].getX()) >= EPSILON ||
                        Math.abs(thisVertices[i].getY() - otherVertices[i].getY()) >= EPSILON) {
                    return false; // Found differing vertices
                }
            }
            return true; // All vertices match
        }
        return false; // Not the same type
    }

}
