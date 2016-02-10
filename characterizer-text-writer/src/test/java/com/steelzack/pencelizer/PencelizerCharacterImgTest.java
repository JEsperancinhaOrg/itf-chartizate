package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class PencelizerCharacterImgTest {

	@Test
	public void testGetBg() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(null, Color.BLACK, 0, ' ');
		assertEquals(Color.BLACK, character.getBg());
	}

	@Test
	public void testGetFg() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(Color.BLACK, null, 0, ' ');
		assertEquals(Color.BLACK, character.getFg());
	}

	@Test
	public void testGetCharacter() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(Color.BLACK, null, 0, ' ');
		assertEquals(' ', character.getCharacter());
	}

	@Test
	public void testGetWidth() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(null, null, 500, ' ');
		assertEquals(500, character.getWidth());
	}
}
