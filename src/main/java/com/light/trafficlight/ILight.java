package com.light.trafficlight;

import com.light.color.Color;
import com.light.trafficlight.exception.InvalidTimeException;
import com.light.trafficlight.exception.SumColorTimeException;

/**
 * Extends base interface ITrafficLight. Adds methods for set/get current time, current color.
 */
public interface ILight extends ITrafficLight {
    /**
     * Computes a Color which will be shine at a specified time.
     * @param time at which need to compute a color.
     * @return Color which will be set in this time.
     * @throws InvalidTimeException if a time is no positive numbers.
     */
    Color getColorByTime(int time) throws InvalidTimeException,SumColorTimeException;

    /**
     * @return Color, which is set in a TrafficLight.
     */
    Color getCurrentColor();

    /**
     * @return current time, which is set in a TrafficLight.
     */
    int getCurrentTime();

    /**
     * Set current time.
     * @param currentTime time, which will be set.
     * @throws InvalidTimeException if a time is no positive numbers.
     * @throws SumColorTimeException
     */

    /**
     * Set a specified time to currentTime.
     * @param currentTime time, which is set in a currentTime.
     * @throws InvalidTimeException if a time is no positive numbers.
     */
    void setCurrentTime(int currentTime) throws InvalidTimeException,SumColorTimeException;

    /**
     * User writes glow-time for each color and minute  "TrafficLight" prints a color which will be shined in this minute.
     */
    void printColorByMinuteTwo();
}
