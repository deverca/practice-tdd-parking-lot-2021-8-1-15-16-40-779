package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets_and_smart_parking_boy() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        Car carmsCar = new Car();
        Car luiseCar = new Car();
        ParkingTicket carmsParkingTicket = smartParkingBoy.park(carmsCar);
        ParkingTicket luiseParkingTicket = smartParkingBoy.park(luiseCar);
        //when
        Car actualCarmsCar = smartParkingBoy.fetch(carmsParkingTicket);
        Car actualLuiseCar = smartParkingBoy.fetch(luiseParkingTicket);
        //then
        assertEquals(carmsCar, actualCarmsCar);
        assertEquals(luiseCar, actualLuiseCar);

    }

    @Test
    public void should_return_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_wrong_ticket() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetch(unrecognizedParkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_fetch_given_parking_lot_standard_parking_boy_and_used_ticket() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
        smartParkingBoy.fetch(parkingTicket);
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.fetch(parkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_park_given_a_parking_lot_with_no_space_parking_boy_and_a_car() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot());
        for (int i = 0; i < 10; i++) {
            smartParkingBoy.park(new Car());
        }
        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> smartParkingBoy.park(new Car()));

        //then
        assertEquals("No available position", exception.getMessage());


    }


    @Test
    public void should_park_in_lot_2_and_return_ticket_when_park_given_two_parking_lots_where_lot_2_has_more_space_smart_parking_boy_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(5);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        smartParkingBoy.park(new Car());

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(parkingLot2, smartParkingBoy.getParkingLot());


    }

    @Test
    public void should_park_in_lot_1_and_return_ticket_when_park_given_two_parking_lots_where_lot_1_has_more_space_smart_parking_boy_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        for (int i = 0; i < 6; i++) {
            smartParkingBoy.park(new Car());
        }
        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(parkingLot2, smartParkingBoy.getParkingLot());


    }
    @Test
    public void should_return_error_message_when_park_given_two_parking_lots_with_all_full_capacity_smart_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        for (int i = 0; i < 15; i++) {
            smartParkingBoy.park(new Car());
        }
        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> smartParkingBoy.park(new Car()));
        //then
        assertEquals("No available position", exception.getMessage());
    }


}
