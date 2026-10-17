package com.epicenterservices.conduitfill.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DomainModelTest {

    @Test
    public void testConduitInitialization() {
        Conduit conduit = new Conduit("EMT", "3/4", 0.533);
        assertEquals("EMT", conduit.getType());
        assertEquals("3/4", conduit.getTradeSize());
        assertEquals(0.533, conduit.getInternalArea(), 0.001);
    }

    @Test
    public void testConductorInitialization() {
        Conductor conductor = new Conductor("THHN", "12 AWG", 0.0133);
        assertEquals("THHN", conductor.getType());
        assertEquals("12 AWG", conductor.getSize());
        assertEquals(0.0133, conductor.getCrossSectionalArea(), 0.0001);
    }

    @Test
    public void testFillCalculationInitialization() {
        Conduit conduit = new Conduit("EMT", "3/4", 0.533);
        Conductor conductor1 = new Conductor("THHN", "12 AWG", 0.0133);
        Conductor conductor2 = new Conductor("THHN", "12 AWG", 0.0133);
        List<Conductor> conductors = Arrays.asList(conductor1, conductor2);

        FillCalculation calculation = new FillCalculation(
                conduit,
                conductors,
                2,
                0.0266,
                0.0499 // Roughly 5% fill
        );

        assertEquals(conduit, calculation.getConduit());
        assertEquals(2, calculation.getConductors().size());
        assertEquals(2, calculation.getConductorCount());
        assertEquals(0.0266, calculation.getTotalConductorArea(), 0.0001);
        assertEquals(0.0499, calculation.getFillPercentage(), 0.0001);
    }
}
