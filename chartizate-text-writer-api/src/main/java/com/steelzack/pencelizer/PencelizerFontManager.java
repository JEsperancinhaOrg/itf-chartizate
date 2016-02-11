package com.steelzack.pencelizer;

import java.util.List;

public interface PencelizerFontManager<T> {

	List<String> getAllUniCodeBlockStringsJava7();

	List<String> getAllUniCodeBlockStringsJava8();

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