package org.jesperancinha.chartizate.distributions;

/**
 * @author joao
 */
public abstract class ChartizateDistribution {

    protected final Character[] orderedListOfCharacters;

    protected final int densityPercentage;

    protected final int rangePercentage;

    public ChartizateDistribution(final Character[] characters, final int densityPercentage,
                                  final int rangePercentage) {
        this.orderedListOfCharacters = characters;
        this.densityPercentage = densityPercentage;
        this.rangePercentage = rangePercentage;
    }

    protected int getDeterminedPosition() {
        return (int) (Math.ceil((double) (densityPercentage * orderedListOfCharacters.length) / 100)) - 1;
    }

    protected int getRange() {
        return (int) (Math.ceil(((double) rangePercentage) / 100 * orderedListOfCharacters.length));
    }

    public abstract Character getCharacterFromArray();
}
