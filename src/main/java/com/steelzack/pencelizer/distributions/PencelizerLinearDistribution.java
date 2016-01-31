package com.steelzack.pencelizer.distributions;

import java.util.Random;

public class PencelizerLinearDistribution extends PencelizerDistribution {

	public PencelizerLinearDistribution(Character[] characters, int densityPercentage, int rangePercentage) {
		super(characters, densityPercentage, rangePercentage);
	}

	public Character getCharacterFromArray() {
		final int determinedPosition = getDeterminedPosition();
		final int range = getRange();
		final Random random = new Random();
		final int selectedIndex = (random.nextInt(range) - range / 2) + determinedPosition;
		if (selectedIndex < orderedListOfCharacters.length) {
			return orderedListOfCharacters[selectedIndex];
		} else if (selectedIndex < 0) {
			return orderedListOfCharacters[0];
		} else {
			return orderedListOfCharacters[orderedListOfCharacters.length - 1];
		}
	}
}
