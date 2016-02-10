package com.steelzack.pencelizer;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * @author joao Manages the prescribed font
 *
 */
public class PencelizerFontManagerImpl implements PencelizerFontManager<Font> {

	private Font font;

	private FontMetrics fontMetrics;

	public PencelizerFontManagerImpl(String fontName, int fontSize) {
		this.font = new Font(fontName, Font.PLAIN, fontSize);
		Canvas c = new Canvas();
		this.fontMetrics = c.getFontMetrics(font);
	}

	/* (non-Javadoc)
	 * @see com.steelzack.pencelizer.PencelizerFontManager#getCharacterWidth(char)
	 */
	@Override
	public int getCharacterWidth(char c) {
		return fontMetrics.stringWidth(new String(new char[] { c }));
	}

	/* (non-Javadoc)
	 * @see com.steelzack.pencelizer.PencelizerFontManager#getCharacterHeight(char)
	 */
	@Override
	public int getCharacterHeight(char c) {
		return font.getSize();
	}

	/* (non-Javadoc)
	 * @see com.steelzack.pencelizer.PencelizerFontManager#getFont()
	 */
	@Override
	public Font getFont() {
		return font;
	}
}
