package com.light.trafficlight;

import com.light.color.Color;
import com.light.trafficlight.exception.InvalidTimeException;

/**
 * Extends base interface ITrafficLight. Adds methods for set/get current time, current color.
 */
public interface ILight extends ITrafficLight {
    /**
     * Computes a Color which will be shine at a specified time.
     *
     * @param time at which need to compute a color.
     * @return color by time.
     * @throws InvalidTimeException if a time is no  positive numbers.
     */
    Color getColorByTime(int time) throws InvalidTimeException;

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
     *
     * @param currentTime time, which will be set.
     */
    void setCurrentTime(int currentTime) throws InvalidTimeException;

    /**
     * User writes glow-time for each color and minute  "TrafficLight" prints a color which will be shined in this minute.
     */
    void printColorByMinuteTwo();
}
