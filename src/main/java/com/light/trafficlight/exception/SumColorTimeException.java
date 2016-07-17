package com.light.trafficlight.exception;

/**
 * An SumColorTimeException is thrown when a glow time of all colors equals zero.
 */
public class SumColorTimeException extends Exception {
    public SumColorTimeException(String message) {
        super(message);
    }
}
