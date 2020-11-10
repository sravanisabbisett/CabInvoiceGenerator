package com.bridgelabz.cabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CabInvoiceTest {
    InvoiceGenerator inVoiceGenerator;
    Ride[] rides;
    InvoiceSummary expectedInvoiceSummary;

    @Before
    public void setUp() throws Exception {
        inVoiceGenerator=new InvoiceGenerator();
        rides= new Ride[]{ new Ride(2.0, 5,RideCategory.NORMAL),
                            new Ride(0.1, 1,RideCategory.PREMIUM)
        };
        expectedInvoiceSummary=new InvoiceSummary(2,45);
    }


    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary=inVoiceGenerator.calculateTotal(Arrays.asList(rides));
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }


    @Test
    public void givenUserId_shouldReturnInvoiceSummary(){
        inVoiceGenerator.addRides("def",new Ride[]{new Ride(5.0,5,RideCategory.NORMAL),new Ride(0.1,1,RideCategory.NORMAL)});
        inVoiceGenerator.addRides("abc",rides);
        InvoiceSummary summary=inVoiceGenerator.getInvoiceSummary("abc");
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,45);
        Assert.assertEquals(expectedInvoiceSummary,summary);

    }

}

