package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends StandardParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingTicket park(Car car) {
        this.setParkingLot(getAvailableParkingLot());
        return getAvailableParkingLot().park(car);
    }

    public ParkingLot getAvailableParkingLot() {
          List<ParkingLot> availableParkingLots = getParkingLots().stream().filter(parkingLot -> parkingLot.getAvailable() > 0).collect(Collectors.toList());
        return availableParkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailable)).orElseThrow(
                NoAvailablePositionException::new);

    }

}
