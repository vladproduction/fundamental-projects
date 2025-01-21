package com.epam.rd.autocode.factory.plot;

public class DisneyPlot implements Plot{

    private Character hero;
    private Character beloved;
    private Character villain;

    public DisneyPlot(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public String toString() {
        return hero.name() + " is great. " + hero.name() + " and " + beloved.name() + " love each other. " +
                villain.name() + " interferes with their happiness but loses in the end.";
    }
}
