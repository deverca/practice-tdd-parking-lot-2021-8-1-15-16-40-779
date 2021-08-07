package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_given_parking_lot_smart_parking_boy_and_car() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_given_parking_lot_with_parked_car_smart_parking_boy_and_ticket() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        Car car = new Car();
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        //when
        Car actualCar = smartParkingBoy.fetch(parkingTicket);
        //then
        assertEquals(car, actualCar);

    }
}
