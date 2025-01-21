package org.author.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * A simple test method
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void runMain() {
        App.main(null);
    }

    @Test
    public void testConstructor() {
        new App();
    }
}
