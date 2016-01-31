package com.steelzack.pencelizer;

import java.awt.Color;

public class PencelizerCharacterImg {

	private Color fg;
	private Color bg;
	private char character;

	public PencelizerCharacterImg(final Color fg, final Color bg, final char character) {
		this.fg = fg;
		this.bg = bg;
		this.character = character;
	}

	public Color getBg() {
		return bg;
	}

	public Color getFg() {
		return fg;
	}

	public char getCharacter() {
		return character;
	}
}
