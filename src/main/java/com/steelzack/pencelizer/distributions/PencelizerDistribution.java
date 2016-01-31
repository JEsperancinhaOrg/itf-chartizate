package com.steelzack.pencelizer.distributions;

import java.util.Set;

public abstract class PencelizerDistribution implements IPencelizerDistribution {

	protected final Set<Character> orderedListOfCharacters;

	public PencelizerDistribution(Set<Character> orderedListOfCharacters) {
		this.orderedListOfCharacters = orderedListOfCharacters;
	}
}
