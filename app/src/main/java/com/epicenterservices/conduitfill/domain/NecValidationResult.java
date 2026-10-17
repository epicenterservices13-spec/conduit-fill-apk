package com.epicenterservices.conduitfill.domain;

/**
 * Represents the result of validating a calculation against NEC rules.
 */
public class NecValidationResult {
    private final boolean isValid;
    private final String message;

    private NecValidationResult(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public static NecValidationResult valid() {
        return new NecValidationResult(true, "Calculation is NEC compliant.");
    }

    public static NecValidationResult invalid(String reason) {
        return new NecValidationResult(false, reason);
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
}
