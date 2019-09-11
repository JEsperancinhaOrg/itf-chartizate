package org.jesperancinha.chartizate.distributions;

public abstract class ChartizateDistributionAbstract implements ChartizateDistribution {

    protected final Character[] orderedListOfCharacters;

    protected final int densityPercentage;

    protected final int rangePercentage;

    public ChartizateDistributionAbstract(final Character[] characters,
                                          final int densityPercentage,
                                          final int rangePercentage) {
        this.orderedListOfCharacters = characters;
        this.densityPercentage = densityPercentage;
        this.rangePercentage = rangePercentage;
    }

    public int getDeterminedPosition() {
        return (int) (Math.ceil((double) (densityPercentage * orderedListOfCharacters.length) / 100)) - 1;
    }

    public int getRange() {
        return (int) (Math.ceil(((double) rangePercentage) / 100 * orderedListOfCharacters.length));
    }

    public abstract Character getCharacterFromArray();

}
