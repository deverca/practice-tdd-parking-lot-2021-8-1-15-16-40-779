package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    public static final int CAPACITY = 10;
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        if (parkingLots.isEmpty()) {
            return parkingLot.park(car);
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.parkedPosition.size() < CAPACITY) {
                this.parkingLot = parkingLot;
                return parkingLot.park(car);
            }
        }
        throw new NoAvailablePositionException();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingLots.isEmpty()) {
            return parkingLot.fetch(parkingTicket);
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.parkedPosition.containsKey(parkingTicket)) {
                return parkingLot.fetch(parkingTicket);
            }
        }
        return null;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

}
