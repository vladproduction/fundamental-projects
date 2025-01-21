package com.epam.rd.autotasks;


public enum Direction {

    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public int getDegrees() {
        return this.degrees;
    }

    public static Direction ofDegrees(int degrees) {
        if(degrees < 0){
            degrees = (degrees % 360 + 360) % 360;
        } else {
            degrees = degrees % 360;
        }

        switch (degrees){
            case 0:
            case 360: return N;
            case 45: return NE;
            case 90: return E;
            case 135: return SE;
            case 180: return S;
            case 225: return SW;
            case 270: return W;
            case 315: return NW;
            default: return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = ((degrees % 360) + 360) % 360;

        Direction closest = N;

        int smallestDiff = 360;

        for (Direction direction : Direction.values()) {
            int diff = Math.abs(degrees - direction.getDegrees());

            if (diff > 180) {
                diff = 360 - diff;
            }

            if (diff < smallestDiff) {
                smallestDiff = diff;
                closest = direction;
            }

        }

        return closest;
    }

    public Direction opposite() {
        switch (this) {
            case N: return S;
            case NE: return SW;
            case E: return W;
            case SE: return NW;
            case S: return N;
            case SW: return NE;
            case W: return E;
            case NW: return SE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null");
        }
        int diff = this.getDegrees() - direction.getDegrees();

        diff = (diff + 360) % 360;

        if (diff > 180) {
            diff = 360 - diff;
        }

        return diff;
    }
}
