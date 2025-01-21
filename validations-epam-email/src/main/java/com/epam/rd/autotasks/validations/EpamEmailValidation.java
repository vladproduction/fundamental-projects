package com.epam.rd.autotasks.validations;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static final String EMAIL_PATTERN = "^[a-zA-Z]+_[a-zA-Z0-9]+@epam\\.com$";
    private static final Set<String> existingEmails = new HashSet<>();
    private static final String EPAM_COM = "@epam.com";
    private static final String UNDERSCORE = "_";

    public static boolean validateEpamEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = emailPattern.matcher(email);

        if (!matcher.matches()) {
            return false;
        }

        String[] partsOfEmail = email.substring(0, email.lastIndexOf("@")).split(UNDERSCORE);
        String firstName = partsOfEmail[0];
        String lastName = partsOfEmail[1];

        String newEmail = email;
        int countExisting = 1;

        while (existingEmails.contains(newEmail)) {
            newEmail = firstName + UNDERSCORE + lastName + countExisting + EPAM_COM;
            countExisting++;
        }

        existingEmails.add(newEmail);
        return true;
    }

}





