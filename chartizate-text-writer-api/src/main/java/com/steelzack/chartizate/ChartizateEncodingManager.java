package com.steelzack.chartizate;

import java.lang.Character.UnicodeBlock;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public abstract class ChartizateEncodingManager<FONT> {
	protected final UnicodeBlock block;

	protected Set<Character> orderedCharacters = new TreeSet<Character>(getComparator());

	protected Character[] characters;
	
	protected final ChartizateFontManager<FONT> fontManager;

	protected int maximumHeight = 0;
	
	public ChartizateEncodingManager(UnicodeBlock block, ChartizateFontManager<FONT> fontManager) {
		super();
		this.block = block;
		this.fontManager = fontManager;
	}

	abstract int getCharacterFullness(Character character);

	abstract void init();

	abstract Character[] getCharacters();
	
	protected int computeFullness(double fullNess, double total) {
		return (int) (fullNess / total * 1000);
	}
	
	private Comparator<Character> getComparator() {
		return new Comparator<Character>() {
			public int compare(Character o1, Character o2) {
				double fullNess1 = getCharacterFullness(o1);
				double fullNess2 = getCharacterFullness(o2);
				Integer comparisonResult = (Integer) ((fullNess1 < fullNess2) ? -1 : 0);
				if (comparisonResult == 0) {
					comparisonResult = o1.compareTo(o2);
				}

				return comparisonResult;
			}
		};
	}}
