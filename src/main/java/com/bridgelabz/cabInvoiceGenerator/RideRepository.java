package com.bridgelabz.cabInvoiceGenerator;

import java.util.*;

public class RideRepository {
    Map<String, List<Ride>> userRides=null;

    public RideRepository() {
        this.userRides=new HashMap<>();
    }
    public void addRide(String userId, List<Ride> rides) {
        List<Ride> userRideList = this.userRides.get(userId);
        if(userRideList == null) userRideList =new ArrayList<>(rides);
        else userRideList.addAll(rides);
        this.userRides.put(userId, userRideList);
    }

    public List<Ride> getRides(String userId) {
        return this.userRides.get(userId);
    }
    public Map<String, List<Ride>> getRideRepositoryMap(){
        return this.userRides;
    }

}

