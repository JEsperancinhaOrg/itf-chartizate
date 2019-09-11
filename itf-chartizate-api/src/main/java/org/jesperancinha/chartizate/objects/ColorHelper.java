package org.jesperancinha.chartizate.objects;

public class ColorHelper {
    private double alpha = 0;
    private double red = 0;
    private double green = 0;
    private double blue = 0;


    public void divideByDenominator(int commonDenominator) {
        this.alpha = this.alpha / commonDenominator;
        this.red = this.red / commonDenominator;
        this.green = this.green / commonDenominator;
        this.blue = this.blue / commonDenominator;
    }

    public void addAlpha(double alpha) {
        this.alpha += alpha;
    }

    public void addRed(double red) {
        this.red += red;
    }

    public void addGreen(double green) {
        this.green += green;
    }

    public void addBlue(double blue) {
        this.blue += blue;
    }

    public int getRed() {
        return (int) red;
    }

    public int getGreen() {
        return (int) green;
    }

    public int getBlue() {
        return (int) blue;
    }

    public int getAlpha() {
        return (int) alpha;
    }
}