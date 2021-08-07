package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void should_park_in_first_parking_lot_and_return_ticket_when_park_given_parking_boy_with_multiple_parking_lots_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(new Car());
        //then
        assertNotNull(parkingTicket);

    }

    @Test
    public void should_park_in_second_parking_lot_and_return_parking_ticket_when_park_given_multiple_parking_lots_with_first_is_full_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        ParkingTicket parkingTicket;
        for (int i = 0; i < 10; i++) {
            standardParkingBoy.park(new Car());
        }
        //when
        parkingTicket = standardParkingBoy.park(new Car());
        //then
        assertNotNull(parkingTicket);
        assertEquals(standardParkingBoy.getParkingLot(), parkingLot2);
    }

    @Test
    public void should_return_error_message_when_park_given_multiple_parking_lots_with_all_full_capacity_parking_boy_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        for (int i = 0; i < 20; i++) {
            standardParkingBoy.park(new Car());
        }
        //when
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> standardParkingBoy.park(new Car()));
        //then
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    public void should_return_parked_car_when_fetch_given_multiple_parking_lots_with_parked_car_parking_boy_and_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        //when
        Car actualCar = standardParkingBoy.fetch(parkingTicket);
        //then
        assertEquals(car, actualCar);
    }

    //    Given multiple parking lots with full capacity, standard parking boy, and parking ticket for car in parking lot 1
//    When fetch
//    Then return the right car
    @Test
    public void should_return_right_car_when_fetch_twice_given_parking_boy_multiple_parking_lots_with_both_full_capacity_parking_boy_and_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car carmsCar = new Car();
        Car luiseCar = new Car();
        ParkingTicket carmsParkingTicket = new ParkingTicket();
        ParkingTicket luiseParkingTicket = new ParkingTicket();
        for (int i = 0; i < 20; i++) {
            if (i == 9) {
                carmsParkingTicket = standardParkingBoy.park(carmsCar);
            } else if (i == 19) {
                luiseParkingTicket = standardParkingBoy.park(luiseCar);
            } else {
                standardParkingBoy.park(new Car());
            }
        }
        //when
        Car actualCarmsCar = standardParkingBoy.fetch(carmsParkingTicket);
        Car actualLuiseCar = standardParkingBoy.fetch(luiseParkingTicket);
        //then
        assertEquals(carmsCar, actualCarmsCar);
        assertEquals(luiseCar, actualLuiseCar);

    }

}
