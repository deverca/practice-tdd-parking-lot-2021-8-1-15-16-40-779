package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
