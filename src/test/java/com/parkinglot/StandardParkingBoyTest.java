package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {


    @Test
    public void should_return_ticket_when_park_given_a_parking_lot_and_a_car() {
        //given
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy();
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        //then
        assertNotNull(parkingTicket);

    }


}
