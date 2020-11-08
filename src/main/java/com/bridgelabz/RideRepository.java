package com.bridgelabz;

public class RideRepository {
    public final int userID;
    public final Ride[] rides;

    public RideRepository(int userID, Ride[] rides) {
        this.userID=userID;
        this.rides=rides;
    }
}
