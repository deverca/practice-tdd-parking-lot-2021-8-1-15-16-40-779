package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {


    @Test
    public void should_return_ticket_when_park_given_a_parking_lot_parking_boy_and_a_car() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(new ParkingLot());
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        //then
        assertNotNull(parkingTicket);

    }

    @Test
    public void should_return_parked_car_when_fetch_given_a_parking_lot_standard_parking_boy_and_ticket() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(new ParkingLot());
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        //when
        Car actualCar = standardParkingBoy.fetch(parkingTicket);
        //then
        assertEquals(car, actualCar);
    }

    @Test
    public void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets_and_parking_boy() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(new ParkingLot());
        Car carmsCar = new Car();
        Car luiseCar = new Car();
        ParkingTicket carmsParkingTicket = standardParkingBoy.park(carmsCar);
        ParkingTicket luiseParkingTicket = standardParkingBoy.park(luiseCar);
        //when
        Car actualCarmsCar = standardParkingBoy.fetch(carmsParkingTicket);
        Car actualLuiseCar = standardParkingBoy.fetch(luiseParkingTicket);
        //then
        assertEquals(carmsCar, actualCarmsCar);
        assertEquals(luiseCar, actualLuiseCar);

    }

    @Test
    public void should_return_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_wrong_ticket() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(new ParkingLot());
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(unrecognizedParkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_used_ticket() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = standardParkingBoy.park(new Car());
        standardParkingBoy.fetch(parkingTicket);
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> standardParkingBoy.fetch(parkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_park_given_a_parking_lot_with_no_space_parking_boy_and_a_car() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(new ParkingLot());
        for (int i = 0; i < 10; i++) {
            standardParkingBoy.park(new Car());
        }
        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.park(new Car()));

        //then
        assertEquals("No available position", exception.getMessage());


    }
}
