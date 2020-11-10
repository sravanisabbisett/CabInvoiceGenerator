package com.bridgelabz.cabInvoiceGenerator;

public enum RideCategory {
    NORMAL( 10, 1, 5),
    PREMIUM( 15, 2, 20);

    private final double costPerKilometer;
    private final int costPerMinute;
    private final double minimumCostPerRide;

    RideCategory(double costPerKilometer, int costPerMinute, double minimumCostPerRide) {
        this.costPerKilometer = costPerKilometer;
        this.costPerMinute = costPerMinute;
        this.minimumCostPerRide = minimumCostPerRide;
    }

    public double calculateFarePerRide(Ride ride) {
        double totalFare = ride.distance * costPerKilometer + ride.time * costPerMinute;
        return Math.max(minimumCostPerRide, totalFare);
    }

}
