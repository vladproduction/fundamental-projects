package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {

        if(color == null){
            return false;
        }
        String hexStringPattern = "^#[0-9A-Fa-f]{6}$|^#[0-9A-Fa-f]{3}$";
        Pattern pattern = Pattern.compile(hexStringPattern);
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();

    }
}





