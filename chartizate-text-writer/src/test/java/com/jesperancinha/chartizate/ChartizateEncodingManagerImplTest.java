package com.jesperancinha.chartizate;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author joao
 */
public class ChartizateEncodingManagerImplTest {

	/**
	 * This test is currently ignored because the character conversion only works correctly for Java8
	 *
	 * @
	 */
	@Test
	@Ignore
	public void testInit_Latin() {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManagerImpl manager = new ChartizateEncodingManagerImpl(
				Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager);
		manager.init();
		assertEquals(
				"[Ţ, ċ, ı, Ÿ, ć, Ļ, ņ, ŋ, ų, Ŷ, Ģ, ĉ, Ċ, č, ę, Ġ, į, ĸ, Ľ, Ŀ, ŗ, Ť, Ć, Ķ, Ş, Ų, ą, ė, ġ, Ĺ, ń, ŉ, ō, Ĝ, Ą, Ĉ, Č, Į, ļ, ľ, ŀ, Ł, ň, ő, ū, ŷ, Ĳ, Ŋ, Ś, ē, ě, ĝ, Ğ, ģ, ħ, ŏ, ş, ũ, ű, Ŗ, Ŝ, Š, Ū, Ĵ, Ŧ, Ō, ā, ď, đ, ĥ, ĩ, ī, İ, ĵ, œ, ŕ, ŭ, ſ, Ā, Ď, Đ, Ę, Ņ, Ũ, Ű, Ő, ż, ĕ, ğ, Ė, Ĥ, Ŕ, Ŭ, Ů, ŵ, Ŏ, Ă, ă, ĳ, ĺ, ł, Ń, Œ, Ř, ř, ś, ť, ź, Ż, Ŵ, Ē, Ě, Ħ, Ň, ů, Ź, ž, ķ, ŝ, š, Ĩ, Ī, ĭ, ţ, Ž, Ĕ, Ĭ, ŧ]",
				Arrays.toString(manager.getCharacters()));
	}

	/**
	 * NOTE: It tests dot density for each code point. It does not reflect human
	 * perception of fullness. For example W you will find that is a less denser
	 * character than others. However looking at it it does give the effect of
	 * fullness
	 *
	 * @
	 */
	@Test
	public void testInit_Latin_Visual_Density_Test() {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManagerImpl manager = new ChartizateEncodingManagerImpl(
				Character.UnicodeBlock.LATIN_EXTENDED_A,
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
	public void testGetCharacterFullness_H() {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager<Font> manager = new ChartizateEncodingManagerImpl(
				Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};

		final int h = manager.getCharacterFullness('H');
		assertThat(h).isAnyOf(442, 225);
	}

	@Test
	public void testGetCharacterFullness_Special_Z() {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager<Font> manager = new ChartizateEncodingManagerImpl(
				Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		final int zSpecial = manager.getCharacterFullness('ž');
		assertThat(zSpecial).isAnyOf(600, 280, 260);
	}

	@Test
	public void testGetCharacterFullness_Special_L() {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager<Font> manager = new ChartizateEncodingManagerImpl(
				Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		final int lSpecial = manager.getCharacterFullness('Ĺ');
		assertThat(lSpecial).isAnyOf(383,216);
	}

	@Test
	public void testGetCharacterFullness_Special_W() {
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);
		final ChartizateEncodingManager<Font> manager = new ChartizateEncodingManagerImpl(
				Character.UnicodeBlock.LATIN_EXTENDED_A,
				fontManager) {
			@Override
			protected int getMaximumHeight() {
				return 10;
			}
		};
		final int wSpecial = manager.getCharacterFullness('Ŵ');
		assertThat(wSpecial).isAnyOf(600, 277);
	}
}
