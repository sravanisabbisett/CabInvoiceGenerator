package com.bridgelabz;

public class InVoiceGenerator {

    private static final double NORMAL_COST_PER_KILOMETER = 10.0;
    private static final int NORMAL_COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE =5 ;
    private static final double PREMIUM_COST_PER_KILOMETER =15 ;
    private static final int PREMIUM_COST_PER_MINUTE =2 ;
    private static final double PREMIUM_MINIMUM_FARE = 20;


    public double calculateFare(double distance, int time,boolean premiumRide) {
        double totalFare=0;
        if(premiumRide) {
            totalFare = distance * PREMIUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_MINUTE;
            return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
        }else {
            totalFare = distance * NORMAL_COST_PER_KILOMETER + time * NORMAL_COST_PER_MINUTE;
            return Math.max(totalFare, MINIMUM_FARE);
        }
    }

    public InVoiceSummary calculateTotal(Ride[] rides,boolean premiumRide){
        double totalFare=0;
        for(Ride ride:rides){
            totalFare+=this.calculateFare(ride.distance,ride.time,premiumRide);
        }
        return new InVoiceSummary(rides.length, totalFare);
    }
}

