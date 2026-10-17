package com.epicenterservices.conduitfill.domain;

/**
 * Represents a wire/conductor type and size without hardcoding specific NEC dimensions.
 * Dimensions should be provided by a verified NEC data source.
 */
public class Conductor {
    private final String type; // e.g. "THHN", "XHHW"
    private final String size; // e.g. "12 AWG", "4/0 AWG"
    private final double crossSectionalArea; // Area taken up by the conductor

    public Conductor(String type, String size, double crossSectionalArea) {
        this.type = type;
        this.size = size;
        this.crossSectionalArea = crossSectionalArea;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getCrossSectionalArea() {
        return crossSectionalArea;
    }
}
