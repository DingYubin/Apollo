package com.apollo.elegant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldJavaTest {

    @BeforeEach
    void setUp() {
        System.out.println("== before ==");
    }

    @AfterEach
    void tearDown() {
        System.out.println("== after ==");
    }

    @Test
    void main() {
        System.out.println("Test HelloWorldJava");
    }
}