package com.bridgelabz;

public class InVoiceSummary {
    private final int noOfRides;
    private final double totalFare;
    private final double averageFare;

    public InVoiceSummary(int noOfRides, double totalFare) {
        this.noOfRides=noOfRides;
        this.totalFare=totalFare;
        this.averageFare=this.totalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InVoiceSummary that = (InVoiceSummary) o;
        return noOfRides == that.noOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

}
