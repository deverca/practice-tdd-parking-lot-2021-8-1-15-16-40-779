package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    List<ParkingTicket> usedTickets = new ArrayList<>();

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car returnCar = parkedPosition.get(parkingTicket);

        if (!usedTickets.contains(parkingTicket)) {
            parkedPosition.remove(parkingTicket);
            usedTickets.add(parkingTicket);
            return returnCar;
        }
        return null;
    }
}
