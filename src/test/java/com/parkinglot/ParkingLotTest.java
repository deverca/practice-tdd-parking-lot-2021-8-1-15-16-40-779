package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);

    }

    @Test
    public void should_return_car_when_fetch_given_a_parking_lot_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        //when
        Car actualCar = parkingLot.fetch(parkingTicket);
        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car carmsCar = new Car();
        Car luiseCar = new Car();
        ParkingTicket carmsParkingTicket = parkingLot.park(carmsCar);
        ParkingTicket luiseParkingTicket = parkingLot.park(luiseCar);
        //when
        Car actualCarmsCar = parkingLot.fetch(carmsParkingTicket);
        Car actualLuiseCar = parkingLot.fetch(luiseParkingTicket);
        //then
        assertEquals(carmsCar, actualCarmsCar);
        assertEquals(actualLuiseCar, actualLuiseCar);
    }

    @Test
    public void should_return_null_when_fetch_given_a_parking_lot_and_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        //when
        Car actualCar = parkingLot.fetch(parkingTicket);
        //then
        assertNull(actualCar);
    }

}
