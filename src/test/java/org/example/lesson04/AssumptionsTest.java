package org.example.lesson04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTest {
    @Test
    void testAssumption() {
        assumeTrue(1 == 2);
        assertEquals(1, 2);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertTrue(true),
                () -> assertEquals(1, 2),
                () -> assertEquals(1, 3),
                () -> assertFalse(false)
        );
    }
}
