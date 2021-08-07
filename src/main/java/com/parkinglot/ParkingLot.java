package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    public static final int CAPACITY = 10;
    Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingTicket park(Car car) {
        if (parkedPosition.size() < CAPACITY) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            return parkingTicket;
        }
        throw new NoAvailableTicketException();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkedPosition.containsKey(parkingTicket)) {
            Car returnCar = parkedPosition.get(parkingTicket);
            parkedPosition.remove(parkingTicket);
            return returnCar;
        }
        throw new UnrecognizedParkingTicketException();
    }
}
