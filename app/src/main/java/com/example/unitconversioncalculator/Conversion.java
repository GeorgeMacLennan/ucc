package com.example.unitconversioncalculator;

public class Conversion {
    static final int FEET = 1;
    static final int INCHES = 2;
    static final int POUNDS = 3;
    static final int MILES = 4;
    static final double FEET_TO_METERS = 0.3048;
    static final double INCHES_TO_CM = 2.56;
    static final double POUNDS_TO_GRAMS = 453.592;
    static final double MILES_TO_KM = 1.60934;

    private int isA;
    public String inputLabel;
    public String outputLabel;

    public Double inputValue;
    public Double outputValue;

    public Conversion() {
        isA = FEET;

        inputLabel = "Feet";
        outputLabel = "Meters";
        inputValue = 0.0;
        outputValue = 0.0;
    }

    public void switch_toFtM() {
        isA = FEET;
        inputLabel = "Feet";
        outputLabel = "Meters";
        compute();
    }

    public void switch_toInCm() {
        isA = INCHES;
        inputLabel = "Inches";
        outputLabel = "Centimeters";
        compute();
    }

    public void switch_toLbG() {
        isA = POUNDS;
        inputLabel = "Pounds";
        outputLabel = "Grams";
        compute();
    }

    public void switch_toMiKm() {
        isA = MILES;
        inputLabel = "Miles";
        outputLabel = "Kilometers";
        compute();
    }

    public void compute() {
        switch (isA) {
            case FEET:
                outputValue = inputValue * FEET_TO_METERS;
                break;
            case INCHES:
                outputValue = inputValue * INCHES_TO_CM;
                break;
            case POUNDS:
                outputValue = inputValue * POUNDS_TO_GRAMS;
                break;
            case MILES:
                outputValue = inputValue * MILES_TO_KM;
                break;
        }
    }
}
