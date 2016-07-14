package com.light.trafficlight;

/**
 * ITrafficLight can show a color at the specified time.
 */
public interface ITrafficLight {
    /**
     * User writes a minute and  "TrafficLight" prints a color which will be shined in this minute.
     */
    void printColorByMinute();
}
