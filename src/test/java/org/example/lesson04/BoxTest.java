package org.example.lesson04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BoxTest {
    static Box box;

    @Nested
    class WhenEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }

        @Test
        void checkExceptionWhenTryToMixEmptyBox() {
            assertThatNullPointerException().isThrownBy(() -> box.mixBalls());
        }

        @Test
        void testOurException() {
            assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.deleteBall());
        }

        @Nested
        class WhenIsBalls {
            @BeforeEach
            void addBall() {
                box.addBall();
            }
            @Test
            void ballAdditionTest() {
                int ballsCount = box.getBallCounter();
                box.addBall();
                Assertions.assertEquals(box.getBallCounter(), ballsCount + 1);
            }
        }
    }
}
