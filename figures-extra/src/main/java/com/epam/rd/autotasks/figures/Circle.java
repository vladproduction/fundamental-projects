package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private final Point center;
    private final double radius;
    private static final double EPSILON = 1e-10; // Tolerance for double comparisons

    public Circle(Point center, double radius) {
        if(radius <= 0 || center == null){
            throw new IllegalArgumentException("Radius must be positive or/and center not null");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(figure instanceof Circle){
            Circle otherCircle = (Circle)figure;
            boolean sameCenter = ((Math.abs(this.center.getX() - otherCircle.center.getX())) < EPSILON) &&
                    ((Math.abs(this.center.getY() - otherCircle.center.getY())) < EPSILON);
            boolean sameRadius = Math.abs(this.radius - otherCircle.radius) < EPSILON;
            return sameCenter && sameRadius;
        }
        return false;
    }

}
