package com.apollo.elegant.experiment

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test

internal class HelloWorldTest {

    @BeforeEach
    fun setUp() {
        println("=== before ===")
    }

    @AfterEach
    fun tearDown() {
        println("=== after ===")
    }

    @Test
    fun main() {
        println("hello kotlin")
    }
}