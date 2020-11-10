package com.bridgelabz.cabInvoiceGenerator;

public class Ride {
    public final double distance;
    public final int time;
    public RideCategory cabRideType;


    public Ride(double distance, int time,RideCategory cabRideType) {
        this.distance=distance;
        this.time=time;
        this.cabRideType=cabRideType;
    }
}

