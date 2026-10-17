package com.epicenterservices.conduitfill.calculation;

import com.epicenterservices.conduitfill.domain.Conductor;
import com.epicenterservices.conduitfill.domain.Conduit;
import com.epicenterservices.conduitfill.domain.FillCalculation;

import java.util.List;

/**
 * Interface defining the contract for calculating conduit fill.
 * Implementations must rely on verified NEC data.
 */
public interface ConduitFillEngine {
    /**
     * Calculates the fill percentage of a conduit given a list of conductors.
     *
     * @param conduit The conduit being filled.
     * @param conductors The list of conductors inside the conduit.
     * @return A FillCalculation result detailing the total area and fill percentage.
     */
    FillCalculation calculateFill(Conduit conduit, List<Conductor> conductors);
}
