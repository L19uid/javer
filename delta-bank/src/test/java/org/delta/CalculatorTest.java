package org.delta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }
    @Test
    void sub() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sub(10, 5));
    }
    @Test
    void mul() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.mul(1, 5));
    }
    @Test
    void div() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.div(10, 2));
    }
    @Test
    void pow() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.pow(2));
        assertEquals(9, calculator.pow(3));
        assertEquals(16, calculator.pow(4));
    }
}