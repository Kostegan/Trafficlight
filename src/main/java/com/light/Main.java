package com.light;

import com.light.trafficlight.ITrafficLight;
import com.light.trafficlight.TrafficLight;

/**
 * Simply displays color by time.
 */
public class Main {
    public static void main(String[] args) {
        ITrafficLight trafficLight = new TrafficLight();
        trafficLight.printColorByMinute();
    }
}
