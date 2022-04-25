package com.tinkabell.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    private Cinema cinnamon = null;

    @BeforeEach
    public void setup() {
        cinnamon = new Cinema();
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    void checkHaveSeats(int n) {
        assertTrue(cinnamon.haveSeats(n), "Check can have " + n + " seats");
    }

    @ParameterizedTest
    @CsvSource({"1, A1", "2, A1, A2", "3, A1, A2, A3"})
    void checkAllocateSeats(int n, String expected) {
        assertEquals(expected, cinnamon.allocateSeats(n), "Can allocate " + n + " seat");
    }

    @Test
    void checkAllocateSeat() {
        assertEquals("A1", cinnamon.allocateSeat(), "Can allocate 1 seat");
    }

}