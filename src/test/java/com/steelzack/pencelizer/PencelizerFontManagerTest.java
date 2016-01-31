package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PencelizerFontManagerTest {

	@Test
	public void testPencelizerFontManager() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetCharacterWidth() throws Exception {
		final PencelizerFontManager manager = new PencelizerFontManager("Arial", 10);

		assertEquals(6, manager.getCharacterWidth('a'));
		assertEquals(7, manager.getCharacterWidth('A'));

	}
}
