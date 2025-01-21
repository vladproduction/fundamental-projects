package com.epam.rd.autocode.factory.plot;

public class DisneyCharacter implements Character{

    private String name;

    public DisneyCharacter(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
