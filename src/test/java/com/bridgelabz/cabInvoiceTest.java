package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
