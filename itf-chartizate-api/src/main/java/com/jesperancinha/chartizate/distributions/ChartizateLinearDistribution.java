package com.jesperancinha.chartizate.distributions;

import java.util.Random;

public class ChartizateLinearDistribution extends ChartizateDistribution {

    public ChartizateLinearDistribution(Character[] characters, int densityPercentage, int rangePercentage) {
        super(characters, densityPercentage, rangePercentage);
    }

    public Character getCharacterFromArray() {
        final int determinedPosition = getDeterminedPosition();
        final int range = getRange();
        final Random random = new Random();
        int selectedIndex = (random.nextInt(range) - range / 2) + determinedPosition;
        if (selectedIndex < 0) {
            selectedIndex = 0;
        }
        if (selectedIndex < orderedListOfCharacters.length) {
            return orderedListOfCharacters[selectedIndex];
        } else {
            return orderedListOfCharacters[orderedListOfCharacters.length - 1];
        }
    }
}
