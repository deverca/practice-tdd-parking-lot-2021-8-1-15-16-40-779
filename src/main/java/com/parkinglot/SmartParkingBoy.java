package com.parkinglot;

import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy {
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingTicket park(Car car) {
        return super.park(car);
    }

}
