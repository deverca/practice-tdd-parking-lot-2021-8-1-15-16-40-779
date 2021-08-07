package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_given_parking_lot_smart_parking_boy_and_car() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        //then
        assertNotNull(parkingTicket);
    }


}
