package com.light.trafficlight;

import com.light.color.Color;
import com.light.trafficlight.exception.InvalidTimeException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class TrafficLightTest {
    private ILight createTrafficLight() {
        return new TrafficLight();
    }

    @Test
    public void getSetCurrentTime() throws InvalidTimeException {
        ILight trafficLight = new TrafficLight();
        assertEquals("Current time is: ", 0, trafficLight.getCurrentTime());
        assertEquals("Current color is: ", Color.Green, trafficLight.getCurrentColor());
        trafficLight.setCurrentTime(23);
        assertEquals("Current time is: ", 23, trafficLight.getCurrentTime());
        assertEquals("Current color is: ", Color.Yellow, trafficLight.getCurrentColor());
    }

    @Test
    public void checkOnGreenColor() throws InvalidTimeException {
        ILight light = new TrafficLight();
        assertEquals("Color is: ", "Green", light.getColorByTime(0).name());
    }

    @Test
    public void checkOnGreenColorEleven() throws InvalidTimeException {
        ILight light = new TrafficLight();
        assertEquals("Color is: ", "Green", light.getColorByTime(11).name());
    }

    @Test
    public void checkOnYellowColor() throws InvalidTimeException {
        ILight light = new TrafficLight();
        assertEquals("Color is: ", "Yellow", light.getColorByTime(3).name());
    }

    @Test
    public void checkOnYellowColorThirteen() throws InvalidTimeException {
        ILight light = new TrafficLight();
        assertEquals("Color is: ", "Yellow", light.getColorByTime(13).name());
    }

    @Test
    public void checkOnRedColor() throws InvalidTimeException {
        ILight light = new TrafficLight();
        assertEquals("Color is: ", "Yellow", light.getColorByTime(4).name());
    }

    @Test
    public void checkOnRedColorSixteen() throws InvalidTimeException {
        ILight light = new TrafficLight();
        assertEquals("Color is: ", "Red", light.getColorByTime(16).name());
    }


    @Test
    public void checkOnRedOtherGlowTime() throws InvalidTimeException {
        ILight light = new TrafficLight();
        Color.Red.setGlowTime(2);
        assertEquals("Color is: ", "Red", light.getColorByTime(7).name());
    }

    @Test
    public void checkOnGreenOtherGlowTime() throws InvalidTimeException {
        ILight light = new TrafficLight();
        Color.Red.setGlowTime(2);
        assertEquals("Color is: ", "Green", light.getColorByTime(8).name());
    }

    @Test(expected = InvalidTimeException.class)
    public void setInvalidTime() throws InvalidTimeException {
        ILight trafficLight = new TrafficLight();
        trafficLight.setCurrentTime(-23);
    }

    @Test
    public void checkColorOtherGlowTimes() throws InvalidTimeException {
        ILight light = new TrafficLight();
        Color.Red.setGlowTime(12);
        Color.Yellow.setGlowTime(23);
        Color.Green.setGlowTime(31);
        assertEquals("Color is: ", "Yellow", light.getColorByTime(299).name());
    }

    @Test
    public void checkColorOneGlowTimeZero() throws InvalidTimeException {
        ILight light = new TrafficLight();
        Color.Red.setGlowTime(4);
        Color.Yellow.setGlowTime(0);
        Color.Green.setGlowTime(2);
        assertEquals("Color is: ", "Red", light.getColorByTime(6).name());
    }

    @Test
    public void checkColorTwoGlowTimeZero() throws InvalidTimeException {
        ILight light = new TrafficLight();
        Color.Red.setGlowTime(0);
        Color.Yellow.setGlowTime(0);
        Color.Green.setGlowTime(2);
        assertEquals("Color is: ", "Green", light.getColorByTime(6).name());
    }

}
