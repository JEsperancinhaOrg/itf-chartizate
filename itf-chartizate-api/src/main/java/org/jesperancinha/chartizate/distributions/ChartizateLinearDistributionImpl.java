package org.jesperancinha.chartizate.distributions;

import lombok.Builder;

import java.util.Random;

@Builder
public class ChartizateLinearDistributionImpl implements ChartizateDistribution{

    protected final Character[] orderedListOfCharacters;

    protected final int densityPercentage;

    protected final int rangePercentage;

    public int getDeterminedPosition() {
        return (int) (Math.ceil((double) (densityPercentage * orderedListOfCharacters.length) / 100)) - 1;
    }

    public int getRange() {
        return (int) (Math.ceil(((double) rangePercentage) / 100 * orderedListOfCharacters.length));
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
