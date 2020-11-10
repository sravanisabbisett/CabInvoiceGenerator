package com.bridgelabz.cabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceGenerator {

    private static final double NORMAL_COST_PER_KILOMETER = 10.0;
    private static final int NORMAL_COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    private static final double PREMIUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final double PREMIUM_MINIMUM_FARE = 20;
    RideRepository rideRepository;
    RideCategory rideCategory;

    public InvoiceGenerator(){
        this.rideRepository=new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * NORMAL_COST_PER_KILOMETER + time * NORMAL_COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateTotal(List<Ride> rides){
        double totalFare=0;
        for(Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, Arrays.asList(rides));
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateTotal(rideRepository.getRides(userId));
    }
}

