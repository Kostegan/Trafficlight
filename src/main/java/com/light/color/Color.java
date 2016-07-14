package com.light.color;

/**
 * Every colors has value "glowTime" which stores a glowing-time.
 */
public enum Color {
    Green(2),
    Yellow(3),
    Red(5);

    Color(int glowTime) {
        this.glowTime = glowTime;
    }

    /**
     * Stores glowing-time.
     */
    private int glowTime;

    /**
     * @return glowing-time for color
     */
    public int getGlowTime() {
        return glowTime;
    }

    /**
     * @param glowTime - set a glowing-time for color
     */
    public void setGlowTime(int glowTime) {
        this.glowTime = glowTime;
    }
}
