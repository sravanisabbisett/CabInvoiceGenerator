package com.bridgelabz;

public class InVoiceGenerator {

    private static final double NORMAL_COST_PER_KILOMETER = 10.0;
    private static final int NORMAL_COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE =5 ;

    public double calculateFare(double distance, int time) {
        double totalFare=distance*NORMAL_COST_PER_KILOMETER+time*NORMAL_COST_PER_MINUTE;
        if(totalFare<MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }
}
