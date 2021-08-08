package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_ticket_when_park_given_parking_lot_super_smart_parking_boy_and_car() {
        //given
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //then
        assertNotNull(parkingTicket);
    }
}
