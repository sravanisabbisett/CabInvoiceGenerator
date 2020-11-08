package com.bridgelabz;

import com.bridgelabz.cabInvoiveGenerator.InVoiceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class cabInvoiceTest {
    InVoiceGenerator inVoiceGenerator;
    @Before
    public void setUp() throws Exception {
        inVoiceGenerator=new InVoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {
        double fare=inVoiceGenerator.calculateFare(5.0,5);
        Assert.assertEquals(55,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double fare=inVoiceGenerator.calculateFare(0.1,1);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides= { new Ride(2.0, 5),
                        new Ride(0.1, 1)
        };
        InVoiceSummary summary=inVoiceGenerator.calculateTotal(rides);
        InVoiceSummary expectedInVoiceSummary=new InVoiceSummary(2,30);
        Assert.assertEquals(expectedInVoiceSummary,summary);
    }

    @Test
    public void givenUserId_ShouldReturnUserInvoiceService() {
        RideRepository[] rideRepository= {
                new RideRepository(1, new Ride[]{new Ride(4.0, 6), new Ride(10.0, 12)}),
                new RideRepository(2, new Ride[]{new Ride(2.0, 5), new Ride(0.1, 1), new Ride(5.0, 5)}),
                new RideRepository(3, new Ride[]{new Ride(5.0, 10), new Ride(10.0, 20)})
        };
        InVoiceService invoiceService=new InVoiceService(Arrays.asList(rideRepository));
        InVoiceSummary inVoiceSummary= invoiceService.getInvoice(2);
        InVoiceSummary expectedInVoiceSummary=new InVoiceSummary(3,85);
        Assert.assertEquals(expectedInVoiceSummary,inVoiceSummary);
    }

}
