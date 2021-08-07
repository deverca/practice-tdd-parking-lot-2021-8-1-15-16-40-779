package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;


    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots, int capacity) {
        for (ParkingLot parkingLot : parkingLots) {
            this.parkingLot = parkingLot;
            parkingLot.setCapacity(capacity);
        }
    }

    public ParkingTicket park(Car car) {
        if (parkingLots.isEmpty()) {
            return parkingLot.park(car);
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.parkedPosition.size() < parkingLot.getCapacity()) {
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
        throw new UnrecognizedParkingTicketException();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setCapacity(int capacity) {
        parkingLot.setCapacity(capacity);
    }
}
