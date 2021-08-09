package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends StandardParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingTicket park(Car car) {
        this.setParkingLot(getLotWithHighRate());
        return getParkingLot().park(car);
    }

    private ParkingLot getLotWithHighRate() {
        return getParkingLots().stream().max(Comparator.comparing(this::getRate)).get();
    }

    public double getRate(ParkingLot parkingLot) {
        try {
            return (double) parkingLot.getAvailable() / parkingLot.getCapacity();
        } catch (Exception exception) {
        }
        return 0;
    }



}
