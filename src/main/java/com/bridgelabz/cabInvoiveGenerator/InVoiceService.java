package com.bridgelabz.cabInvoiveGenerator;

import com.bridgelabz.InVoiceGenerator;
import com.bridgelabz.InVoiceSummary;
import com.bridgelabz.RideRepository;

import java.util.ArrayList;
import java.util.List;

public class InVoiceService {

    public List<RideRepository> rideRepository;

    public InVoiceService(List<RideRepository> rideRepository) {
        this.rideRepository = rideRepository;
    }

    public InVoiceSummary getInvoice(int userID,boolean premiumRide) {
        InVoiceSummary invoiceSummary = null;
        for (RideRepository userRides : rideRepository) {
            if (userRides.userID == userID) {
                invoiceSummary = new InVoiceGenerator().calculateTotal(userRides.rides,premiumRide);
            }
        }
        return invoiceSummary;
    }
}

