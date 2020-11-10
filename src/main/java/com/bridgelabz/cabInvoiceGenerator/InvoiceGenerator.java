package com.bridgelabz.cabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceGenerator {

    RideRepository rideRepository;

    public InvoiceGenerator(){
        this.rideRepository=new RideRepository();
    }

    /*public InvoiceSummary calculateTotal(List<Ride> rides){
        double totalFare=0;
        for(Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }*/
    public InvoiceSummary calculateTotal(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            if(ride.cabRideType != null)
                totalFare += ride.cabRideType.calculateFarePerRide(ride);
        }
        return new InvoiceSummary(rides.size(),totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, Arrays.asList(rides));
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateTotal(rideRepository.getRides(userId));
    }
}

