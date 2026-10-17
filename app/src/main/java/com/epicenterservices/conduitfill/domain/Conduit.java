package com.epicenterservices.conduitfill.domain;

/**
 * Represents a conduit type and size without hardcoding specific NEC dimensions.
 * Dimensions should be provided by a verified NEC data source.
 */
public class Conduit {
    private final String type; // e.g. "EMT", "PVC Schedule 40"
    private final String tradeSize; // e.g. "3/4", "1"
    private final double internalArea; // Area available for fill

    public Conduit(String type, String tradeSize, double internalArea) {
        this.type = type;
        this.tradeSize = tradeSize;
        this.internalArea = internalArea;
    }

    public String getType() {
        return type;
    }

    public String getTradeSize() {
        return tradeSize;
    }

    public double getInternalArea() {
        return internalArea;
    }
}
