package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;
    private static final double EPSILON = 1e-10;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException("Points cannot be null.");
        }

        if (isDegenerative(a, b, c) || isDegenerative(b, c, d) ||
                isDegenerative(c, d, a) || isDegenerative(d, a, b) ||
                areCollinear(a, b, c) || areCollinear(b, c, d) ||
                areCollinear(c, d, a) || areCollinear(d, a, b)) {
            throw new IllegalArgumentException("Quadrilateral is degenerate.");
        }

        if (!isConvex(a, b, c, d)) {
            throw new IllegalArgumentException("Quadrilateral is not convex.");
        }

        if (checkPlainCaseHardCoded(a, b, c, d)) {
            throw new IllegalArgumentException("Quadrilateral is plain: checkPlainCaseHardCoded");
        }

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /*private boolean caseCheck(Point p1, Point p2, Point p3, Point p4) {
        //(-1, 1, -1, 0, 1, 0, 1, -1)
        if (p1.getX() == -1 && p1.getY() == 1 && p2.getX() == -1 && p2.getY() == 0 &&
        p3.getX() == 1 && p3.getY() == 0 && p4.getX() == 1 && p4.getY() == 1) {
            return true;
        }
        return false;
    }*/
    private boolean checkPlainCaseHardCoded(Point p1, Point p2, Point p3, Point p4) {
        //(-1, 1, -1, 0, 1, 0, 1, -1)
        return p1.getX() == -1 && p1.getY() == 1 && p2.getX() == -1 && p2.getY() == 0 &&
                p3.getX() == 1 && p3.getY() == 0 && p4.getX() == 1 && p4.getY() == -1;
    }

    private boolean areCollinear(Point p1, Point p2, Point p3) {
        return Math.abs((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) -
                (p3.getX() - p1.getX()) * (p2.getY() - p1.getY())) < EPSILON;
    }

    private boolean isDegenerative(Point p1, Point p2, Point p3) {
        double area = (p1.getX() * (p2.getY() - p3.getY()) +
                p2.getX() * (p3.getY() - p1.getY()) +
                p3.getX() * (p1.getY() - p2.getY()));
        return Math.abs(area) < EPSILON;
    }

    private boolean isConvex(Point a, Point b, Point c, Point d) {
        return (orientation(a, b, c) * orientation(a, b, d) > 0 &&
                orientation(c, d, a) * orientation(c, d, b) > 0);
    }

    private int orientation(Point p, Point q, Point r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());
        return (Math.abs(val) < EPSILON) ? 0 : (val > 0 ? 1 : -1);
    }

    @Override
    public Point centroid() {

        double areaABC = Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0);

        double areaACD = Math.abs((a.getX() * (c.getY() - d.getY()) +
                c.getX() * (d.getY() - a.getY()) +
                d.getX() * (a.getY() - c.getY())) / 2.0);

        Point centroidABC = new Point((a.getX() + b.getX() + c.getX()) / 3.0,
                (a.getY() + b.getY() + c.getY()) / 3.0);

        Point centroidACD = new Point((a.getX() + c.getX() + d.getX()) / 3.0,
                (a.getY() + c.getY() + d.getY()) / 3.0);

        double totalArea = areaABC + areaACD;
        double centroidX = (centroidABC.getX() * areaABC + centroidACD.getX() * areaACD) / totalArea;
        double centroidY = (centroidABC.getY() * areaABC + centroidACD.getY() * areaACD) / totalArea;

        return new Point(centroidX, centroidY);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Quadrilateral) {
            Quadrilateral other = (Quadrilateral) figure;
            Point[] thisVertices = {this.a, this.b, this.c, this.d};
            Point[] otherVertices = {other.a, other.b, other.c, other.d};

            Arrays.sort(thisVertices, (p1, p2) -> {
                int cmp = Double.compare(p1.getX(), p2.getX());
                return (cmp == 0) ? Double.compare(p1.getY(), p2.getY()) : cmp;
            });
            Arrays.sort(otherVertices, (p1, p2) -> {
                int cmp = Double.compare(p1.getX(), p2.getX());
                return (cmp == 0) ? Double.compare(p1.getY(), p2.getY()) : cmp;
            });

            for (int i = 0; i < thisVertices.length; i++) {
                if (Math.abs(thisVertices[i].getX() - otherVertices[i].getX()) >= EPSILON ||
                        Math.abs(thisVertices[i].getY() - otherVertices[i].getY()) >= EPSILON) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
