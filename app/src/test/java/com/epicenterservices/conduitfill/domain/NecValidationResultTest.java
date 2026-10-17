package com.epicenterservices.conduitfill.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class NecValidationResultTest {

    @Test
    public void testValidResult() {
        NecValidationResult result = NecValidationResult.valid();
        assertTrue(result.isValid());
        assertEquals("Calculation is NEC compliant.", result.getMessage());
    }

    @Test
    public void testInvalidResult() {
        String reason = "Conduit fill exceeds NEC Chapter 9 Table 1 maximum 40% allowance.";
        NecValidationResult result = NecValidationResult.invalid(reason);
        assertFalse(result.isValid());
        assertEquals(reason, result.getMessage());
    }
}
