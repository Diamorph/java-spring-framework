package org.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    private List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        boolean test = true;
        assertTrue(test);
        assertTrue(todos.contains("AWS"));
        assertEquals(3, todos.size());
//        assertArrayEquals(new int[] {1, 2}, new int[] {2, 1});
    }
}
