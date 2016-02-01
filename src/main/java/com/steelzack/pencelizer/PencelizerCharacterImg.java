package com.steelzack.pencelizer;

import java.awt.Color;

public class PencelizerCharacterImg {

	private Color fg;
	private Color bg;
	private char character;
	private int width;

	public PencelizerCharacterImg(final Color fg, final Color bg, final int width, final char character) {
		this.fg = fg;
		this.bg = bg;
		this.width = width;
		this.character = character;
	}

	public Color getBg() {
		return bg;
	}

	public Color getFg() {
		return fg;
	}

	public int getWidth() {
		return width;
	}
	
	public char getCharacter() {
		return character;
	}
	
	@Override
	public String toString() {
		return String.valueOf(character);
	}
}
