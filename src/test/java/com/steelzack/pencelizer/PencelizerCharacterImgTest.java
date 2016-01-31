package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class PencelizerCharacterImgTest {

	@Test
	public void testGetBg() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(null, Color.BLACK,' ');
		assertEquals(Color.BLACK, character.getBg());
	}

	@Test
	public void testGetFg() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(Color.BLACK, null,' ');
		assertEquals(Color.BLACK, character.getFg());
	}

	@Test
	public void testGetCharacter() throws Exception {
		final PencelizerCharacterImg character = new PencelizerCharacterImg(Color.BLACK, null,' ');
		assertEquals(' ', character.getCharacter());
	}

}
