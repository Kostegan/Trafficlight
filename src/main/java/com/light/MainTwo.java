package com.light;

import com.light.trafficlight.ILight;
import com.light.trafficlight.TrafficLight;

/**
 * Offers set a glow time for every colors.
 */
public class MainTwo {
    public static void main(String[] args) {
        ILight trafficLight = new TrafficLight();
        trafficLight.printColorByMinuteTwo();
    }
}
