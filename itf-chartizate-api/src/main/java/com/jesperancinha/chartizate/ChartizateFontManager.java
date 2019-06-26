package com.jesperancinha.chartizate;

import com.jesperancinha.chartizate.distributions.ChartizateDistributionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChartizateFontManager<T> {

    public static List<String> getAllDistributionTypes() {
        final List<String> distributionTypes = new ArrayList<>();

        for (ChartizateDistributionType type : ChartizateDistributionType.values()) {
            distributionTypes.add(type.toString());
        }
        return distributionTypes;
    }

    /**
     * Gets the width of a particular character
     *
     * @param c Character
     * @return Width of character
     */
    abstract int getCharacterWidth(char c);

    /**
     * Gets full height of a particular character
     *
     * @param c Character
     * @return Width of character
     */
    abstract int getCharacterHeight(char c);

    abstract T getFont();

    abstract int getFontSize();
}