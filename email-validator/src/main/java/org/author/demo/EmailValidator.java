package org.author.demo;

public class EmailValidator {

    private static final String EMAIL_ADDRESS_SIGN = "@";
    private static final String DEFAULT_USER_NAME = "User"; // Constant for a placeholder name

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false; // Null is not a valid email
        }

        int atIndex = email.indexOf(EMAIL_ADDRESS_SIGN);
        if (atIndex <= 0 || atIndex == email.length() - 1) {
            return false; // Email must have characters before and after '@'
        }

        // Check if there are only valid characters in the local part and domain
        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        // Use regular expressions to validate the local and domain parts
        String localPartRegex = "^[A-Za-z0-9._%+-]+$"; // Allow letters, digits, and specific symbols
        String domainPartRegex = "^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; // Allows domains with valid TLDs

        boolean isLocalPartValid = localPart.matches(localPartRegex);
        boolean isDomainPartValid = domainPart.matches(domainPartRegex);

        return isLocalPartValid && isDomainPartValid;
    }

    public String getDomain(String email) {
        if (email == null || !isValidEmail(email)) {
            return ""; // Return empty string for invalid or null email
        }
        String[] parts = email.split(EMAIL_ADDRESS_SIGN);
        return parts.length > 1 ? parts[1] : ""; // Return domain if available
    }

    public String getUserName(String name) {
        return name != null && !name.isEmpty() ? name : DEFAULT_USER_NAME; // Use constant if name is null or empty
    }

}