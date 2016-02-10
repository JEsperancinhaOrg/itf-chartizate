package com.steelzack.pencelizer.distributions;

/**
 * 
 * @author joao
 *
 */
public abstract class PencelizerDistribution implements IPencelizerDistribution {

	protected final Character[] orderedListOfCharacters;

	protected final int densityPercentage;

	protected final int rangePercentage;

	public PencelizerDistribution(final Character[] characters, final int densityPercentage,
			final int rangePercentage) {
		this.orderedListOfCharacters = characters;
		this.densityPercentage = densityPercentage;
		this.rangePercentage= rangePercentage;
	}
	

	protected int getDeterminedPosition() {
		return (int)(((double)densityPercentage)/100 * orderedListOfCharacters.length);
	}
	protected int getRange() {
		return (int)(Math.ceil(((double)rangePercentage)/100 * orderedListOfCharacters.length));
	}
}
