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
    @CsvSource(value = {
            "1: A1",
            "2: A1, A2",
            "3: A1, A2, A3"
    }, delimiter = ':')
    void checkAllocateSeats(int n, String expected) {
        assertEquals(expected, cinnamon.allocateSeats(n), "Can allocate " + n + " seats");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1: 1: A1",
            "1: 5: A5",
            "1: 6: B1",
            "1: 8: B3",
            "1: 15: C5",
            "2: 1: A1, A2",
            "2: 2: A3, A4",
            "2: 3: A5, B1",
            "2: 7: C3, C4",
            "3: 1: A1, A2, A3",
            "3: 2: A4, A5, B1",
            "3: 4: B5, C1, C2",
            "3: 5: C3, C4, C5"
    }, delimiter = ':')
    void checkSeatNames(int request, int n, String expected) {
        for (int i = 0; i < n-1; i++) {
            cinnamon.allocateSeats(request);
        }
        assertEquals(expected, cinnamon.allocateSeats(request), "Correctly allocate " + request + " seats");
    }

    @Test
    void checkAllocateSeat() {
        assertEquals("A1", cinnamon.allocateSeat(), "Can allocate 1 seat");
    }

    @ParameterizedTest
    @CsvSource({"0", "4", "-1", "10"})
    void checkInvalidInput(int request){
        String response = cinnamon.allocateSeats(request);
        assertTrue(response.startsWith("Error"), "Error for " + request + " seats request");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1: 1: 15",
            "2: 1: 15",
            "3: 1: 15",
            "2: 2: 7",
            "3: 2: 7",
            "1: 3: 5",
            "2: 3: 5",
            "3: 3: 5"
    }, delimiter = ':')
    void checkNoSeats(int request, int n, int times) {
        for (int i = 0; i < n-1; i++) {
            cinnamon.allocateSeats(times);
        }
        assertFalse(cinnamon.haveSeats(request), "No enough seats for " + request + " seats after requesting " + (n * times));
    }

}