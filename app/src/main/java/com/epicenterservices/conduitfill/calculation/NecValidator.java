package com.epicenterservices.conduitfill.calculation;

import com.epicenterservices.conduitfill.domain.FillCalculation;
import com.epicenterservices.conduitfill.domain.NecValidationResult;

/**
 * Interface defining the contract for validating fill calculations against NEC rules.
 * Implementations must rely on verified NEC Chapter 9 Tables.
 */
public interface NecValidator {
    /**
     * Validates a fill calculation against NEC allowable fill percentages.
     *
     * @param calculation The calculation to validate.
     * @return A result indicating if the calculation is valid and providing any relevant NEC warnings.
     */
    NecValidationResult validate(FillCalculation calculation);
}
