package com.apollo.elegant.experiment;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class FactorialTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("=== before ===");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("=== after ===");
    }

    @Test
    public void fact() {
        System.out.println(Factorial.fact(1));
        Assertions.assertEquals(1, Factorial.fact(1));
        Assertions.assertEquals(2, Factorial.fact(2));
        Assertions.assertEquals(6, Factorial.fact(3));
        Assertions.assertEquals(3628800, Factorial.fact(10));
        Assertions.assertEquals(2432902008176640000L, Factorial.fact(20));
    }
}