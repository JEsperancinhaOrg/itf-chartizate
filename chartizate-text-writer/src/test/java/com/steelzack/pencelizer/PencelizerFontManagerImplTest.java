package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import java.awt.Font;

import org.junit.Test;

/**
 * 
 * @author joao
 *
 */
public class PencelizerFontManagerImplTest {
	@Test
	public void testGetCharacterWidth() throws Exception {
		final PencelizerFontManager<Font> manager = new PencelizerFontManagerImpl("Arial", 10);

		assertEquals(6, manager.getCharacterWidth('a'));
		assertEquals(7, manager.getCharacterWidth('A'));

	}
}
