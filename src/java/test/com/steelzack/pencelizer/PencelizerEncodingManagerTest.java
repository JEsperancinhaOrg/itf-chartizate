package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PencelizerEncodingManagerTest {

	@Test
	public void testInit_Latin() throws Exception {
		final PencelizerFontManager fontManager = new PencelizerFontManager("Arial", 10);
		final PencelizerEncodingManager manager = new PencelizerEncodingManager(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager);
		manager.init();
	}
	
	@Test
	public void testGetCharacterFullness_H() throws Exception {
		final PencelizerFontManager fontManager = new PencelizerFontManager("Arial", 10);
		final PencelizerEncodingManager manager = new PencelizerEncodingManager(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager){
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
	assertEquals(new Integer((int)(17d/70d * 1000)),(Integer)manager.getCharacterFullness(new Character('H')));
	}
	
	@Test
	public void testGetCharacterFullness_Special_Z() throws Exception {
		final PencelizerFontManager fontManager = new PencelizerFontManager("Arial", 10);
		final PencelizerEncodingManager manager = new PencelizerEncodingManager(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager){
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int)(16d/50d*1000)),(Integer)manager.getCharacterFullness(new Character('ž')));
	}
	
	@Test
	public void testGetCharacterFullness_Special_L() throws Exception {
		final PencelizerFontManager fontManager = new PencelizerFontManager("Arial", 10);
		final PencelizerEncodingManager manager = new PencelizerEncodingManager(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager){
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int)(13d/60d * 1000)),(Integer)manager.getCharacterFullness(new Character('Ĺ')));
	}
	
	@Test
	public void testGetCharacterFullness_Special_LastLatin() throws Exception {
		final PencelizerFontManager fontManager = new PencelizerFontManager("Arial", 10);
		final PencelizerEncodingManager manager = new PencelizerEncodingManager(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager){
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int)(8d/30d * 1000)),(Integer)manager.getCharacterFullness(new Character('ſ')));
	}
}
