package com.epam.rd.autocode.factory.plot;

import java.util.Arrays;

public class MarvelPlot implements Plot{

    private Character[] heroes;
    private EpicCrisis epicCrisis;
    private Character villain;

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        StringBuilder heroesList = new StringBuilder();
        for (Character hero : heroes) {
            if (heroesList.length() > 0) {
                heroesList.append(", ");
            }
            heroesList.append("brave ").append(hero.name());
        }

        return epicCrisis.name() + " threatens the world. But " + heroesList + " on guard. " +
                "So, no way that intrigues of " + villain.name() + " overcome the willpower of inflexible heroes";
    }
}
