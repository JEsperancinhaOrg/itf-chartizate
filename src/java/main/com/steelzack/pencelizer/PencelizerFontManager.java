package com.steelzack.pencelizer;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * @author joao Manages the prescribed font
 *
 */
public class PencelizerFontManager {

	private Font font;

	private FontMetrics fontMetrics;

	public PencelizerFontManager(String fontName, int fontSize) {
		this.font = new Font(fontName, Font.PLAIN, fontSize);
		Canvas c = new Canvas();
		this.fontMetrics = c.getFontMetrics(font);
	}

	/**
	 * Gets the width of a particular character
	 * 
	 * @param c
	 *            Character
	 * @return Width of character
	 */
	public int getCharacterWidth(char c) {
		return fontMetrics.stringWidth(new String(new char[] { c }));
	}

	/**
	 * Gets full height of a particular character
	 * 
	 * @param c
	 *            Character
	 * @return Width of character
	 */
	public int getCharacterHeight(char c) {
		return font.getSize();
	}

	public Font getFont() {
		return font;
	}
}
