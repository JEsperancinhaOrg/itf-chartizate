package com.steelzack.chartizate;

import android.graphics.Typeface;

import java.util.List;

/**
 * @author joao Manages the prescribed font
 *
 */
public class ChartizateFontManagerImpl implements ChartizateFontManager<Typeface> {


	private String fontString;
	private int fontSize;

	public ChartizateFontManagerImpl(String fontString, int fontSize) {
		this.fontSize = fontSize;
		this.fontString = fontString;
	}

	@Override
	public List<String> getAllUniCodeBlockStringsJava7() {
		return null;
	}

	@Override
	public List<String> getAllUniCodeBlockStringsJava8() {
		return null;
	}

	@Override
	public int getCharacterWidth(char c) {
		return 0;
	}

	@Override
	public int getCharacterHeight(char c) {
		return 0;
	}

	@Override
	public Typeface getFont() {
		return null;
	}
}
