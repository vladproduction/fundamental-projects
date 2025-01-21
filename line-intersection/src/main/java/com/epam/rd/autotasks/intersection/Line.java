package com.epam.rd.autotasks.intersection;

public class Line {

    private final int k;
    private final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }
    public Point intersection(Line other) {

        if(this.k == other.k){
            if(this.b == other.b){
                return null; //concise
            }
            return null; //parallel
        }

        double x = (double) (other.b - this.b) / (this.k - other.k);
        double y = this.k * x + this.b;

        return new Point((int)Math.round(x), (int)Math.round(y));
    }

}
