package org.junit;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @Test
    void test1() {
        System.out.println("test 1");
    }

    @Test
    void test2() {
        System.out.println("test 2");
    }

    @Test
    void test3() {
        System.out.println("test 3");
    }

    @Test
    void test4() {
        System.out.println("test 4");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }
}
