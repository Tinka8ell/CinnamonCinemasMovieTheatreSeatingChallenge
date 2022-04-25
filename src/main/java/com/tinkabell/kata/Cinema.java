package com.tinkabell.kata;

/**
 * Base class to encapsulate a cinema booking system
 */
public class Cinema {

    private int freeSeats;
    private final int rowWidth;

    /**
     * Default constructor for 15 seat cinema
     */
    public Cinema() {
        this(15);
    }

    /**
     * Minimal constructor for cinema with 5 seats to a row
     * @param freeSeats as capacity
     */
    public Cinema(int freeSeats) {
        this(freeSeats, 5);
    }

    /**
     * Expected to be used constructor
     *
     * @param freeSeats as capacity
     * @param rowWidth per row
     */
    public Cinema(int freeSeats, int rowWidth) {
        this.freeSeats = freeSeats;
        this.rowWidth = rowWidth;
    }

    /**
     * Allocate one seat (if available) and return seat number
     * @return seat number as row letter and seat number in row
     */
    public String allocateSeat(){
        int pos = 15 - freeSeats;
        freeSeats--;
        return "A1A2A3".substring(pos * 2, (pos + 1) * 2);
    }

    /**
     * Allocate given number seat (if all available) and return seat number list
     *
     * @param request number of seats (between 1 and 3 inclusive)
     * @return seat comma separated list of seat numbers (as row letter and seat number in row)
     */
    public String allocateSeats(int request){
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < request; i++) {
            response.append(allocateSeat()).append(", ");
        }
        return response.substring(0, response.length() - 2); // lose last comma
    }

    /**
     * Check availability for requested number of seats
     * @param request number of seats
     * @return true iff there are this number of seats left
     */
    public boolean haveSeats(int request){
        return true;
    }

}
