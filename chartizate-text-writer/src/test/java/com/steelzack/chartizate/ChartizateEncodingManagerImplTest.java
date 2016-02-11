package com.steelzack.chartizate;

import static org.junit.Assert.assertEquals;

import java.awt.Font;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import com.steelzack.chartizate.ChartizateEncodingManager;
import com.steelzack.chartizate.ChartizateEncodingManagerImpl;
import com.steelzack.chartizate.ChartizateFontManager;
import com.steelzack.chartizate.ChartizateFontManagerImpl;

/**
 * 
 * @author joao
 *
 */
public class ChartizateEncodingManagerImplTest {

	/**
	 * This test is currently ignored because the character conversion only works correctly for Java8
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testInit_Latin() throws Exception {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManagerImpl manager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager);
		manager.init();
		assertEquals(
				"[Ţ, ċ, ı, Ÿ, ć, Ļ, ņ, ŋ, ų, Ŷ, Ģ, ĉ, Ċ, č, ę, Ġ, į, ĸ, Ľ, Ŀ, ŗ, Ť, Ć, Ķ, Ş, Ų, ą, ė, ġ, Ĺ, ń, ŉ, ō, Ĝ, Ą, Ĉ, Č, Į, ļ, ľ, ŀ, Ł, ň, ő, ū, ŷ, Ĳ, Ŋ, Ś, ē, ě, ĝ, Ğ, ģ, ħ, ŏ, ş, ũ, ű, Ŗ, Ŝ, Š, Ū, Ĵ, Ŧ, Ō, ā, ď, đ, ĥ, ĩ, ī, İ, ĵ, œ, ŕ, ŭ, ſ, Ā, Ď, Đ, Ę, Ņ, Ũ, Ű, Ő, ż, ĕ, ğ, Ė, Ĥ, Ŕ, Ŭ, Ů, ŵ, Ŏ, Ă, ă, ĳ, ĺ, ł, Ń, Œ, Ř, ř, ś, ť, ź, Ż, Ŵ, Ē, Ě, Ħ, Ň, ů, Ź, ž, ķ, ŝ, š, Ĩ, Ī, ĭ, ţ, Ž, Ĕ, Ĭ, ŧ]",
				Arrays.toString(manager.getCharacters()));
	}

	@Test
	/**
	 * NOTE: It tests dot density for each code point. It does not reflect human
	 * perception of fullness. For example W you will find that is a less denser
	 * character than others. However looking at it it does give the effect of
	 * fullness
	 *
	 * @throws Exception
	 */
	public void testInit_Latin_Visual_Density_Test() throws Exception {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManagerImpl manager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager);
		manager.init();
		System.out.println("\n");
		for (Character character : manager.getCharacters()) {
			for (int i = 0; i < 100; i++) {
				System.out.print(character + " ");
			}
			System.out.println("");
		}
	}

	@Test
	public void testGetCharacterFullness_H() throws Exception {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager manager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int) (17d / 70d * 1000)), (Integer) manager.getCharacterFullness(new Character('H')));
	}

	@Test
	public void testGetCharacterFullness_Special_Z() throws Exception {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager manager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int) (16d / 50d * 1000)), (Integer) manager.getCharacterFullness(new Character('ž')));
	}

	@Test
	public void testGetCharacterFullness_Special_L() throws Exception {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager manager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int) (13d / 60d * 1000)), (Integer) manager.getCharacterFullness(new Character('Ĺ')));
	}

	@Test
	public void testGetCharacterFullness_Special_W() throws Exception {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager manager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		assertEquals(new Integer((int) (28d / 90d * 1000)), (Integer) manager.getCharacterFullness(new Character('Ŵ')));
	}
}
