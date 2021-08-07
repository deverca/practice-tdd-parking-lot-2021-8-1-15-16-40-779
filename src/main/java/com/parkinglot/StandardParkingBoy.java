package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {
    public static final int CAPACITY = 10;
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
                this.parkingLot = parkingLot;
        }

    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
