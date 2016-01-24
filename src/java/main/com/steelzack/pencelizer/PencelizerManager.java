package com.steelzack.pencelizer;

import org.fusesource.jansi.Ansi.Color;

/**
 *
 * @author joao
 * Manages the whole board to be rendered
 */
public class PencelizerManager {

	private PencelizerCharacter[][] pencelizerBoard;

	/**
	 * Creates Pencelizer manager by defining how many lines and columns is the
	 * array going to have
	 * 
	 * @param nLines
	 * @param nColumns
	 */
	public PencelizerManager(int nLines, int nColumns) {
		pencelizerBoard = new PencelizerCharacter[nLines][nColumns];
	}

	/**
	 * Sets character in position with a background color and a foreground
	 * color. Foreground color refers to the color of the character itself
	 * Background color refers to the background color in the cell of the
	 * character
	 * 
	 * @param l
	 *            Number of lines
	 * @param c
	 *            Number of columns
	 * @param fg
	 *            Foreground color
	 * @param bg
	 *            Background color
	 * @param character
	 *            The chosen character
	 */
	public void setPencelizerCharacter(int l, int c, Color fg, Color bg, char character) {

		pencelizerBoard[l][c] = new PencelizerCharacter(fg, bg, character);
	}
}
