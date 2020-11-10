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
    public void givenUserId_shouldReturnInvoiceSummary() throws InvoiceException {
        inVoiceGenerator.addRides("def",new Ride[]{   new Ride(5.0,5,RideCategory.NORMAL),
                                                            new Ride(0.1,1,RideCategory.NORMAL)});
        inVoiceGenerator.addRides("abc",rides);
        try {
            InvoiceSummary summary = inVoiceGenerator.getInvoiceSummary("def");
            Assert.assertEquals(new InvoiceSummary(2, 60), summary);
        }catch (InvoiceException invoiceException){
            throw new InvoiceException("INVALID_USERID",InvoiceException.ExceptionType.INVALID_USERID);
        }

    }
    @Test
    public void givenWrongUserId_shouldThrowException() throws InvoiceException {
        InvoiceSummary summary;
        inVoiceGenerator.addRides("def",  new Ride[]{new Ride(5.0,5,RideCategory.NORMAL),
                                                new Ride(0.1,1,RideCategory.NORMAL)});
        inVoiceGenerator.addRides("abc",rides);
        try{
            summary=inVoiceGenerator.getInvoiceSummary("efg");
            Assert.assertEquals(new InvoiceSummary(2,45), summary);
            throw new InvoiceException("INVALID_USERID",InvoiceException.ExceptionType.INVALID_USERID);
        }catch (InvoiceException invoiceException){
            System.out.println(invoiceException.getMessage());
        }
    }
    @Test
    public void givenWrongExceptedResult_shouldThrowException() throws InvoiceException {
        inVoiceGenerator.addRides("def",  new Ride[]{ new Ride(5.0,5,RideCategory.NORMAL),
                                                            new Ride(0.1,1,RideCategory.NORMAL)});
        inVoiceGenerator.addRides("abc",rides);
        try{
            InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,60);
            InvoiceSummary summary=inVoiceGenerator.getInvoiceSummary("def");
            if(!expectedInvoiceSummary.equals(summary))
                throw new InvoiceException("INVALID_TOTAL_FARE",InvoiceException.ExceptionType.INCORRECT_TOTAL_FARE);
        }catch (InvoiceException invoiceException){
            System.out.println(invoiceException.getMessage());
        }
    }

}

