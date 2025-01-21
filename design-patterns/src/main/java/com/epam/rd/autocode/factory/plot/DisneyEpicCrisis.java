package com.epam.rd.autocode.factory.plot;

public class DisneyEpicCrisis implements EpicCrisis{

    private String crisisDescription;

    public DisneyEpicCrisis(String crisisDescription) {
        this.crisisDescription = crisisDescription;
    }

    @Override
    public String name() {
        return crisisDescription;
    }
}
