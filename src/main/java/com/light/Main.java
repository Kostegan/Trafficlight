package com.light;

import com.light.trafficlight.ILight;
import com.light.trafficlight.ITrafficLight;
import com.light.trafficlight.TrafficLight;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
//        ITrafficLight trafficLight = new TrafficLight();
//        trafficLight.printColorByMinute();

        ILight trafficLight = new TrafficLight();
        trafficLight.printColorByMinuteTwo();
    }
}
