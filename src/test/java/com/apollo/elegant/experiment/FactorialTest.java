package com.apollo.elegant.experiment;

import org.junit.jupiter.api.*;

public class FactorialTest {

    private Factorial underTest;

    @BeforeEach
    public void before() {
        System.out.println("== before ==");
    }

    @AfterEach
    public void after() {
        System.out.println("== after ==");
    }

    @Test
    public void fact() {
        System.out.println(Factorial.fact(10));
        Assertions.assertEquals(1, Factorial.fact(1));
        Assertions.assertEquals(2, Factorial.fact(2));
        Assertions.assertEquals(6, Factorial.fact(3));
        Assertions.assertEquals(3628800, Factorial.fact(10));
        Assertions.assertEquals(2432902008176640000L, Factorial.fact(20));
    }

    @Nested
    class WhenFacting {
        private final long N = 56;

        @BeforeEach
        void setup() {
        }
    }
}