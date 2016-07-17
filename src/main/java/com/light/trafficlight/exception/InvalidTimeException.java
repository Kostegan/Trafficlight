package com.light.trafficlight.exception;

/**
 * An InvalidTimeException is thrown when a value of time has a invalid value.
 */
public class InvalidTimeException extends Exception {
    public InvalidTimeException(String message){
        super(message);
    }
}
