package com.steelzack.pencelizer;

public interface PencelizerFontManager<T> {

	/**
	 * Gets the width of a particular character
	 * 
	 * @param c
	 *            Character
	 * @return Width of character
	 */
	int getCharacterWidth(char c);

	/**
	 * Gets full height of a particular character
	 * 
	 * @param c
	 *            Character
	 * @return Width of character
	 */
	int getCharacterHeight(char c);

	T getFont();
}