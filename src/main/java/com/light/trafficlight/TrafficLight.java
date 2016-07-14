package com.light.trafficlight;

import com.light.color.Color;
import com.light.trafficlight.exception.InvalidTimeException;

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

    public void setCurrentTime(int currentTime) throws InvalidTimeException {
        this.currentTime = currentTime;
        currentColor = getColorByTime(currentTime);
    }

    /**
     * Calculate a sum all glowing minutes from three colors(Green, Yellow, Red).
     *
     * @return sum all glowing minutes.
     */
    private int getSumGlow() {
        return Color.Green.getGlowTime() + Color.Yellow.getGlowTime() + Color.Red.getGlowTime();
    }

    /**
     * todo add comment
     *
     * @param time which need to convert.
     */
    private int convertTime(int time) {
        int glowSum = getSumGlow();
//        while(time>glowSum){
//            time -=glowSum;
//        }
        if (time > glowSum) {
            time %= glowSum;
        }
        return time;
    }

    /**
     * Defines color at a specified time.
     * todo comment
     *
     * @param time which
     * @throws InvalidTimeException
     */
    private Color defineColor(int time) throws InvalidTimeException {
        checkTimeOnValid(time);
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
     *
     * @param time which will be checked on a validity.
     * @throws InvalidTimeException if time is not a positive number.
     */
    private void checkTimeOnValid(int time) throws InvalidTimeException {
        if (time < 0) {
            throw new InvalidTimeException("Value a specified time: " + time + " is invalid. Value must be positive numbers.");
        }
    }

    @Override
    public Color getColorByTime(int time) throws InvalidTimeException {
        return defineColor(time);
    }

    @Override
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
                    System.out.println("Enter time for a Green color: ");
                    Color.Green.setGlowTime(reader.nextInt());
                    System.out.println("Enter time for a Yellow color: ");
                    Color.Yellow.setGlowTime(reader.nextInt());
                    System.out.println("Enter time for a Red color: ");
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
                }
            }
        } finally {
            reader.close();
        }
    }
}
