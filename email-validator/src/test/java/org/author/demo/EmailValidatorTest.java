package org.author.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailValidatorTest {

    //email
    @Test
    public void testIsValidEmail_ValidEmail_ReturnsTrue() {
        EmailValidator emailValidator = new EmailValidator();
        boolean result = emailValidator.isValidEmail("test@example.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsValidEmail_NullEmail_ReturnsFalse() {
        EmailValidator emailValidator = new EmailValidator();
        boolean result = emailValidator.isValidEmail(null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsValidEmail_MultipleAtSigns_ReturnsFalse() {
        EmailValidator emailValidator = new EmailValidator();
        boolean result = emailValidator.isValidEmail("test@example@com");
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsValidEmail_InvalidEmailFormat_ReturnsFalse() {
        EmailValidator emailValidator = new EmailValidator();
        boolean result = emailValidator.isValidEmail("***@???...");
        Assertions.assertFalse(result);
    }

    //domain
    @Test
    public void testGetDomain_ValidEmail_ReturnsDomain() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getDomain("test@example.com");
        Assertions.assertEquals("example.com", result);
    }

    @Test
    public void testGetDomain_NullEmail_ReturnsEmpty() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getDomain(null);
        Assertions.assertEquals("", result);
    }

    @Test
    public void testGetDomain_EmptyEmail_ReturnsEmpty() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getDomain("");
        Assertions.assertEquals("", result);
    }

    @Test
    public void testGetDomain_InvalidEmailFormat_ReturnsEmpty() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getDomain("test.example.com");
        Assertions.assertEquals("", result);
    }

    //UserName
    @Test
    public void getUsernameTest_ValidName_ReturnsUsername() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getUserName("John");
        Assertions.assertEquals("John", result);
    }

    @Test
    public void getUsernameTest_NullName_ReturnsDefault() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getUserName(null);
        Assertions.assertEquals("User", result);
    }

    @Test
    public void getUsernameTest_EmptyName_ReturnsDefault() {
        EmailValidator emailValidator = new EmailValidator();
        String result = emailValidator.getUserName("");
        Assertions.assertEquals("User", result);
    }



}