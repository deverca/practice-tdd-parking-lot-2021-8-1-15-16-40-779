package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private int available;
    public static final int CAPACITY_10 = 10;
    Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingLot() {
        this.setCapacity(CAPACITY_10);
        this.available = CAPACITY_10;
    }

    public ParkingLot(int capacity) {
        this.setCapacity(capacity);
        this.available = capacity;
    }

    public ParkingTicket park(Car car) {
        if (available > 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            available--;
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

    public int getAvailable() {
        return available;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
