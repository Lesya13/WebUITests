package org.example.lesson04.homeWorkTest;

import org.example.lesson04.homeWork.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    Triangle triangle = new Triangle();

    @Test
    void testGivenThreeSidesOfTriangleNeedsToKnowTheSquareOfTriangle() {
        Assertions.assertEquals(6.0, (triangle.squareOfTriangle()));
    }
}
