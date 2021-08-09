package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailable() > 0) {
                this.parkingLot = parkingLot;
                return parkingLot.park(car);
            }
        }
        throw new NoAvailablePositionException();
    }

    public Car fetch(ParkingTicket parkingTicket) {
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

}
