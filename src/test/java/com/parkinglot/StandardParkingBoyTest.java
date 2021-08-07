package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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


}
