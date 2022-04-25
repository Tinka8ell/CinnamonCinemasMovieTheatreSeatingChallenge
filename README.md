# Cinnamon Cinemas Movie Theatre Seating Challenge

This is a simple challenge just to demonstrate TDD, etc.

Sorry Simon, but this is going to be a bare minimum solutuion.

## The brief

### Setting the Scene
You have a special task from Cinnamon Cinemas to develop a program to allocate seats to customers purchasing tickets for a movie theatre.
Cinnamon Cinemas provided some criteria for how the program should be built.
### Cinnamon Cinemas' Criteria
* Well-designed and tested code representing real-world scenarios
* Evidence of Test-Driven Development being applied
* Clear communication and documentation

## Cinnamon Cinemas Business Requirements
The Cinnamon Cinemas Movie Theatre has 15 seats, arranged in 3 rows of 5
* Rows are assigned a letter from A to C
* Seats are assigned a number from 1 to 5

### User Story
As a Cinnamon Cinemas Movie Theatre Manager
I want to allocate seats to customers, so that I can control reserved seating for the theatre:
* GIVEN a customer wants to request some tickets
* WHEN they request a number of seats between 1 and 3 for a movie
* THEN the customer should be allocated the required number of seats from the available seats on the seating plan
* AND the seats should be recorded as allocated

## Acceptance Criteria and Assumptions
* Write a program that allocates seats based on a random integer “number of seats” between 1 and 3
* Your program should allocate the required number of seats from the available seats starting from seat A1 and filling the auditorium from
left to right, front to back
* All of the seats are available for sale when the program starts
* The program should continue to allocate a random number of seats until it finds there are not enough seats left to complete the request
* Once there are not enough seats available to be allocated then the program can halt

## My Solution
* Quite clearly this is a minimal requirement, so the "Cinema" class will be the base class for better implementations
* Need a constructor - assume base of 15 seats as described, but allow for larger (and smaller) number of seats and different choice of row width
* Need a method to request tickets.  Does not give spec for this, but will implement a cs list of seat numbers, or an error message
* Need a method to either get number of free seets, or if any free seets
* Clearly needs a "test" function to use up all seets

### TDD
* test for error input (< 1 and > 3 seets) 
* test for get 1, 2 & 3
* test for get 3 seets five times works
* test for get 2 seets seven times works
* test for get 1 seets fifteen times works
* test 1 to 2 or 3 three more gets rejected once full
