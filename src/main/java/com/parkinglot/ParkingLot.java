package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    public static final int CAPACITY_10 = 10;
    Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingLot() {
        this.setCapacity(CAPACITY_10);
    }

    public ParkingLot(int capacity) {
        this.setCapacity(capacity);
    }

    public ParkingTicket park(Car car) {
        if (capacity > 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            capacity--;
            return parkingTicket;
        }
        throw new NoAvailablePositionException();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkedPosition.containsKey(parkingTicket)) {
            Car returnCar = parkedPosition.get(parkingTicket);
            parkedPosition.remove(parkingTicket);
            return returnCar;
        }
        throw new UnrecognizedParkingTicketException();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<ParkingTicket, Car> getParkedPosition() {
        return parkedPosition;
    }
}
