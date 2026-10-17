package com.epicenterservices.conduitfill.domain;

import java.util.Collections;
import java.util.List;

/**
 * Represents the result of a conduit fill calculation.
 */
public class FillCalculation {
    private final Conduit conduit;
    private final List<Conductor> conductors;
    private final int conductorCount;
    private final double totalConductorArea;
    private final double fillPercentage;

    public FillCalculation(Conduit conduit, List<Conductor> conductors, int conductorCount, double totalConductorArea, double fillPercentage) {
        this.conduit = conduit;
        this.conductors = Collections.unmodifiableList(conductors);
        this.conductorCount = conductorCount;
        this.totalConductorArea = totalConductorArea;
        this.fillPercentage = fillPercentage;
    }

    public Conduit getConduit() {
        return conduit;
    }

    public List<Conductor> getConductors() {
        return conductors;
    }

    public int getConductorCount() {
        return conductorCount;
    }

    public double getTotalConductorArea() {
        return totalConductorArea;
    }

    public double getFillPercentage() {
        return fillPercentage;
    }
}
