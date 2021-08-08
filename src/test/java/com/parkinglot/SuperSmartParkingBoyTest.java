package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_ticket_when_park_given_parking_lot_super_smart_parking_boy_and_car() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        //when
        ParkingTicket parkingTicket = superSmartParkingBoy.park(new Car());
        //then
        assertNotNull(parkingTicket);
    }
    @Test
    public void should_return_parked_car_when_fetch_given_parking_lot_with_parked_car_super_smart_parking_boy_and_ticket() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        Car car = new Car();
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);
        //when
        Car actualCar = superSmartParkingBoy.fetch(parkingTicket);
        //then
        assertEquals(car, actualCar);

    }
    @Test
    public void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets_and_smart_parking_boy() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        Car carmsCar = new Car();
        Car luiseCar = new Car();
        ParkingTicket carmsParkingTicket = superSmartParkingBoy.park(carmsCar);
        ParkingTicket luiseParkingTicket = superSmartParkingBoy.park(luiseCar);
        //when
        Car actualCarmsCar = superSmartParkingBoy.fetch(carmsParkingTicket);
        Car actualLuiseCar = superSmartParkingBoy.fetch(luiseParkingTicket);
        //then
        assertEquals(carmsCar, actualCarmsCar);
        assertEquals(luiseCar, actualLuiseCar);

    }
    @Test
    public void should_return_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_wrong_ticket() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> superSmartParkingBoy.fetch(unrecognizedParkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

}
