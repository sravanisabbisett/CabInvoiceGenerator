package com.bridgelabz.cabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CabInvoiceTest {
    InvoiceGenerator inVoiceGenerator;

    @Before
    public void setUp() throws Exception {
        inVoiceGenerator=new InvoiceGenerator();

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
        InvoiceSummary summary=inVoiceGenerator.calculateTotal(Arrays.asList(rides));
        InvoiceSummary expectedInVoiceSummary=new InvoiceSummary(2,30);
        Assert.assertEquals(expectedInVoiceSummary,summary);
    }


    @Test
    public void givenUserId_shouldReturnInvoiceSummary(){
        inVoiceGenerator.addRides("abc",new Ride[]{new Ride(2.0,5),new Ride(0.1,1)});
        inVoiceGenerator.addRides("def",new Ride[]{new Ride(5.0,5),new Ride(0.1,1)});
        InvoiceSummary summary=inVoiceGenerator.getInvoiceSummary("def");
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,60);
        Assert.assertEquals(expectedInvoiceSummary,summary);

    }

}

