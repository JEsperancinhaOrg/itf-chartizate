package com.steelzack.pencelizer;

public class PencelizerCharacterImg<T> {

	private T fg;
	private T bg;
	private char character;
	private int width;

	public PencelizerCharacterImg(final T fg, final T bg, final int width, final char character) {
		this.fg = fg;
		this.bg = bg;
		this.width = width;
		this.character = character;
	}

	public T getBg() {
		return bg;
	}

	public T getFg() {
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
