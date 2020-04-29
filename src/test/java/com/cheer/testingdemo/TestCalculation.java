package com.cheer.testingdemo;

import com.cheer.testingdemo.service.Calculation;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
class TestCalculation {

    private static Logger LOGGER = LoggerFactory.getLogger(TestCalculation.class);

    @Autowired
    private Calculation calculation;


    @BeforeAll
    static void beforeClass() {
        LOGGER.info("Before class");
    }

    @BeforeEach
    void beforeEachMethod() {
        LOGGER.info("Before each method");
    }

    @Test
    void testFindMax() {
        Assertions.assertNull(calculation.findMax(null));
        Assertions.assertEquals(1, calculation.findMax(Collections.singletonList(1)));
        Assertions.assertEquals(-2, calculation.findMax(Collections.singletonList(-2)));
        Assertions.assertEquals(5, calculation.findMax(Arrays.asList(0, 1, 2, 3, 4, 5)));
        Assertions.assertEquals(-1, calculation.findMax(Arrays.asList(-1, -2, -5, -6, -3)));
        Assertions.assertEquals(1, calculation.findMax(Arrays.asList(1, 1, 1, 1, 1)));
        Assertions.assertEquals(5, calculation.findMax(Arrays.asList(5, 4, 3, 2, 1, 0)));
        Assertions.assertEquals(Integer.MAX_VALUE, calculation.findMax(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0)));
    }

    @Test
    void testCube() {
        Assertions.assertNull(calculation.cube(null));
        Assertions.assertEquals(0, calculation.cube(0));
        Assertions.assertEquals(-125, calculation.cube(-5));
        Assertions.assertEquals(64, calculation.cube(4));
    }

    @Test
    void testReverseString() {
        Assertions.assertEquals(null, calculation.reverseString(null));
        Assertions.assertEquals("a", calculation.reverseString("a"));
        Assertions.assertEquals("ba", calculation.reverseString("ab"));
        Assertions.assertEquals("dlrow olleh", calculation.reverseString("hello world"));
        Assertions.assertEquals("aaaaa", calculation.reverseString("aaaaa"));
        Assertions.assertEquals("!@#$%^", calculation.reverseString("^%$#@!"));
    }

    @AfterEach
    void afterEach() {
        LOGGER.info("After each method");
    }

    @AfterAll
    static void afterClass() {
        LOGGER.info("After class");
    }
}
