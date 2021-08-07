package com.parkinglot;

public class NoAvailableTicketException extends RuntimeException {
    public NoAvailableTicketException(){
        super("No available position");
    }
}
