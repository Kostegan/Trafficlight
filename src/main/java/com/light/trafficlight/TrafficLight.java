package com.light.trafficlight;

import com.light.color.Color;
import com.light.trafficlight.exception.InvalidTimeException;
import com.light.trafficlight.exception.SumColorTimeException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class TrafficLight implements ILight {
    private Color currentColor;
    private int currentTime;

    public TrafficLight() {
        currentTime = 0;
        currentColor = Color.Green;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) throws InvalidTimeException, SumColorTimeException {
        this.currentTime = currentTime;
        currentColor = getColorByTime(currentTime);
    }

    public Color getColorByTime(int time) throws InvalidTimeException, SumColorTimeException {
        return defineColor(time);
    }

    /**
     * Calculate a sum all glowing minutes from three colors(Green, Yellow, Red).
     * @return sum all glowing minutes.
     */
    private int getSumGlow() {
        return Color.Green.getGlowTime() + Color.Yellow.getGlowTime() + Color.Red.getGlowTime();
    }

    /**
     * todo add comment
     * @param time which need to convert.
     */
    private int convertTime(int time) {
        int glowSum = getSumGlow();
        if (time > glowSum) {
            time %= glowSum;
        }
        return time;
    }

    /**
     * Defines color at a specified time.
     * @param time at which need to compute a color.
     * @return Color which will be shine in this time.
     * @throws InvalidTimeException if time is not a positive number.
     * @throws SumColorTimeException if glow time of all colors equals zero.
     */
    private Color defineColor(int time) throws InvalidTimeException, SumColorTimeException {
        checkTimeOnValid(time);
        checkGlowTimeOnValid();
        int minutes = convertTime(time);
        int greenGlowMinute = Color.Green.getGlowTime();
        int yellowGlow = Color.Yellow.getGlowTime();

        if (minutes <= greenGlowMinute) {
            return Color.Green;
        } else {
            minutes -= greenGlowMinute;
        }
        if (minutes <= yellowGlow) {
            return Color.Yellow;
        } else {
            return Color.Red;
        }
    }

    /**
     * Time must be a positive number.
     * @param time which will be checked on a validity.
     * @throws InvalidTimeException if time is not a positive number.
     */
    private void checkTimeOnValid(int time) throws InvalidTimeException, SumColorTimeException {
        if (time < 0) {
            throw new InvalidTimeException("Value a specified time: " + time + " is invalid. Value must be positive numbers.");
        }
    }

    /**
     * The glow time of all colors should not be equals zero.
     * @throws SumColorTimeException if glow time of all colors equals zero.
     */
    private void checkGlowTimeOnValid() throws SumColorTimeException {
        if (getSumGlow() == 0) {
            throw new SumColorTimeException("The glow time of all colors equals zero. Glow-time for green-color set: " + Color.Green.getGlowTime() + ", for yellow-color set: " + Color.Yellow.getGlowTime() + ", for red-color set: " + Color.Red.getGlowTime());
        }
    }

    public void printColorByMinute() {
        Scanner reader = new Scanner(System.in);
        try {
            String exit = "no";
            while (!exit.equals("yes")) {
                System.out.println("Enter minute: ");
                try {
                    int minute = reader.nextInt();
                    System.out.println("On " + minute + " minute the color will be: " + getColorByTime(minute));
                    System.out.println("----------------------");
                    System.out.println("Exit: yes/no ");
                    exit = reader.next();
                } catch (InputMismatchException e) {
                    System.out.println("Minute must be a digit.");
                    exit = reader.next();
                } catch (InvalidTimeException e) {
                    System.out.println("Minute must be positive numbers");
                } catch (SumColorTimeException e) {
                    System.out.println("The glow time of all colors should not be equals zero.");
                }
            }
        } finally {
            reader.close();
        }
    }

    public void printColorByMinuteTwo() {
        Scanner reader = new Scanner(System.in);
        try {
            String exit = "no";
            while (!exit.equals("yes")) {
                try {
                    System.out.println("Enter glow time for a Green color: ");
                    Color.Green.setGlowTime(reader.nextInt());
                    System.out.println("Enter glow time for a Yellow color: ");
                    Color.Yellow.setGlowTime(reader.nextInt());
                    System.out.println("Enter glow time for a Red color: ");
                    Color.Red.setGlowTime(reader.nextInt());
                    System.out.println("Enter minute: ");
                    int minute = reader.nextInt();
                    System.out.println("On " + minute + " minute the color will be: " + getColorByTime(minute));
                    System.out.println("----------------------");
                    System.out.println("Exit: yes/no ");
                    exit = reader.next();
                } catch (InputMismatchException e) {
                    System.out.println("Minute must be a digit.");
                    exit = reader.next();
                } catch (InvalidTimeException e) {
                    System.out.println("Minute must be positive numbers");
                } catch (SumColorTimeException e) {
                    System.out.println("The glow time of all colors should not be equals zero.");
                }
            }
        } finally {
            reader.close();
        }
    }
}
