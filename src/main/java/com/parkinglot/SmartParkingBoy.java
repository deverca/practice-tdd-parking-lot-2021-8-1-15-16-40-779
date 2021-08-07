package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SmartParkingBoy extends StandardParkingBoy {
    private int capacity;

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots, int capacity) {
        super(parkingLots, capacity);
    }


    public ParkingTicket park(Car car) {

        if (getParkingLots().isEmpty()) {
            return super.park(car);
        }
        this.setParkingLot(getAvailableParkingLot());
        return getAvailableParkingLot().park(car);
    }

    public ParkingLot getAvailableParkingLot() {
        return getParkingLots().stream().min(Comparator.comparing(parkingLot -> parkingLot.parkedPosition.size())).orElseThrow(
                NoSuchElementException::new);
    }


}
