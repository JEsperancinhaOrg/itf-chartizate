package com.jesperancinha.chartizate;

import com.google.common.annotations.VisibleForTesting;
import com.jesperancinha.chartizate.distributions.ChartizateDistributionType;

import java.util.ArrayList;
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
    @VisibleForTesting
    abstract int getCharacterWidth(char c);

    /**
     * Gets full height of a particular character
     *
     * @param c Character
     * @return Width of character
     */
    @VisibleForTesting
    abstract int getCharacterHeight(char c);

    @VisibleForTesting
    abstract T getFont();

    @VisibleForTesting
    abstract int getFontSize();
}