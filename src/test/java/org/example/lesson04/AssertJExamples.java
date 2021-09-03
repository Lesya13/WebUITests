package org.example.lesson04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamples {
    Functions functions = new Functions();

    @Test
    void testIsEvenWithAssertJ() {
        assertThat(Functions.isNumberEven(5)).isFalse();
    }

    @Test
    void testCollection() {
        List<String> list = new ArrayList<>(Arrays.asList("test", "testtt", "test2"));
        assertThat(list).containsAnyOf("test", "yyyy");
        assertThat(1).isGreaterThan(0).isLessThan(2);
    }
}
