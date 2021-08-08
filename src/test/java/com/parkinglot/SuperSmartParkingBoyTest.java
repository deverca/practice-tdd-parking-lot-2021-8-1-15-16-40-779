package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void should_return_parked_car_when_fetch_given_parking_lot_with_parked_car_super_super_smart_parking_boy_and_ticket() {
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
    public void should_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets_and_super_smart_parking_boy() {
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
    public void should_return_error_message_when_fetch_given_parking_lot_super_smart_parking_boy_and_wrong_ticket() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> superSmartParkingBoy.fetch(unrecognizedParkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_fetch_given_parking_lot_super_smart_parking_boy_and_used_ticket() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.fetch(parkingTicket);
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> superSmartParkingBoy.fetch(parkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_park_given_a_parking_lot_with_no_space_super_smart_parking_boy_and_a_car() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot());
        for (int i = 0; i < 10; i++) {
            superSmartParkingBoy.park(new Car());
        }
        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> superSmartParkingBoy.park(new Car()));

        //then
        assertEquals("No available position", exception.getMessage());


    }

    @Test
    public void should_park_in_lot_2_and_return_ticket_when_park_given_two_parking_lots_where_lot_2_has_higher_position_rate_super_smart_parking_boy_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());
        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(parkingLot2, smartParkingBoy.getParkingLot());


    }

    @Test
    public void should_park_in_lot_1_and_return_ticket_when_park_given_two_parking_lots_where_lot_1_has_higher_position_rate_super_smart_parking_boy_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        for (int i = 0; i < 5; i++) {
            smartParkingBoy.park(new Car());
        }
        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(parkingLot1, smartParkingBoy.getParkingLot());


    }

    @Test
    public void should_return_error_message_when_park_given_two_parking_lots_with_all_full_capacity_super_smart_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        for (int i = 0; i < 15; i++) {
            superSmartParkingBoy.park(new Car());
        }
        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> superSmartParkingBoy.park(new Car()));
        //then
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_fetch_given_two_parking_lots_super_smart_parking_boy_and_unrecognized_parking_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> superSmartParkingBoy.fetch(new ParkingTicket()));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_error_message_when_fetch_given_multiple_parking_lots_smart_parking_boy_and_used_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingTicket parkingTicket = superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.fetch(parkingTicket);
        //when
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> superSmartParkingBoy.fetch(parkingTicket));
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    public void should_return_right_car_when_fetch_twice_given_parking_boy_two_parking_lots_with_both_full_capacity_smart_parking_boy_and_two_tickets() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car carmsCar = new Car();
        Car luiseCar = new Car();
        ParkingLot carmsActualParkingLot = new ParkingLot();
        ParkingLot luiseActualParkingLot = new ParkingLot();
        ParkingTicket carmsParkingTicket = new ParkingTicket();
        ParkingTicket luiseParkingTicket = new ParkingTicket();
        for (int i = 0; i < 15; i++) {
            if (i == 0) {
                carmsParkingTicket = superSmartParkingBoy.park(carmsCar);
                carmsActualParkingLot = superSmartParkingBoy.getParkingLot();
            } else if (i == 5) {
                luiseParkingTicket = superSmartParkingBoy.park(luiseCar);
                luiseActualParkingLot = superSmartParkingBoy.getParkingLot();
            } else {
                superSmartParkingBoy.park(new Car());
            }
        }
        //when
        Car actualCarmsCar = superSmartParkingBoy.fetch(carmsParkingTicket);
        Car actualLuiseCar = superSmartParkingBoy.fetch(luiseParkingTicket);
        //then
        assertEquals(carmsCar, actualCarmsCar);
        assertEquals(luiseCar, actualLuiseCar);
        assertEquals(parkingLot1, carmsActualParkingLot);
        assertEquals(parkingLot2, luiseActualParkingLot);

    }
}
