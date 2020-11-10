package com.bridgelabz.cabInvoiceGenerator;

import java.util.List;

public class InvoiceService {

    public List<RideRepository> rideRepository;

   /* public InvoiceService(List<RideRepository> rideRepository) {
        this.rideRepository = rideRepository;
    }

    public InvoiceSummary getInvoice(int userID,boolean premiumRide) {
        InvoiceSummary invoiceSummary = null;
        for (RideRepository userRides : rideRepository) {
            if (userRides.userID == userID) {
                invoiceSummary = new InvoiceGenerator().calculateTotal(userRides.rides,premiumRide);
            }
        }
        return invoiceSummary;
    }*/


}