package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends StandardParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

//    public SuperSmartParkingBoy(ParkingLot parkingLot) {
//        super(parkingLot);
//    }

    public ParkingTicket park(Car car) {

        if (getParkingLots().isEmpty()) {
            return super.park(car);
        }
        this.setParkingLot(getParkingLots().stream().max(Comparator.comparing(this::getRate)).get());
        return getParkingLot().park(car);
    }

    public double getRate(ParkingLot parkingLot) {
        try {
            return (double) parkingLot.getAvailable() / parkingLot.getCapacity();
        } catch (Exception exception) {
        }
        return 0;
    }

}
