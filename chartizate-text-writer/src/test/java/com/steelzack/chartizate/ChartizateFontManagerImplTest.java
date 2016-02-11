package com.steelzack.chartizate;

import static java.lang.Character.UnicodeBlock.ALCHEMICAL_SYMBOLS;
import static java.lang.Character.UnicodeBlock.ARABIC;
import static java.lang.Character.UnicodeBlock.ARABIC_EXTENDED_A;
import static java.lang.Character.UnicodeBlock.ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS;
import static java.lang.Character.UnicodeBlock.ARMENIAN;
import static java.lang.Character.UnicodeBlock.ARROWS;
import static java.lang.Character.UnicodeBlock.BASIC_LATIN;
import static java.lang.Character.UnicodeBlock.BENGALI;
import static java.lang.Character.UnicodeBlock.BLOCK_ELEMENTS;
import static java.lang.Character.UnicodeBlock.BOPOMOFO;
import static java.lang.Character.UnicodeBlock.BOX_DRAWING;
import static java.lang.Character.UnicodeBlock.CHAKMA;
import static java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY;
import static java.lang.Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION;
import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C;
import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D;
import static java.lang.Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS;
import static java.lang.Character.UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS;
import static java.lang.Character.UnicodeBlock.CONTROL_PICTURES;
import static java.lang.Character.UnicodeBlock.CURRENCY_SYMBOLS;
import static java.lang.Character.UnicodeBlock.CYRILLIC;
import static java.lang.Character.UnicodeBlock.DEVANAGARI;
import static java.lang.Character.UnicodeBlock.DINGBATS;
import static java.lang.Character.UnicodeBlock.EMOTICONS;
import static java.lang.Character.UnicodeBlock.ENCLOSED_ALPHANUMERICS;
import static java.lang.Character.UnicodeBlock.ENCLOSED_ALPHANUMERIC_SUPPLEMENT;
import static java.lang.Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS;
import static java.lang.Character.UnicodeBlock.ENCLOSED_IDEOGRAPHIC_SUPPLEMENT;
import static java.lang.Character.UnicodeBlock.GENERAL_PUNCTUATION;
import static java.lang.Character.UnicodeBlock.GEOMETRIC_SHAPES;
import static java.lang.Character.UnicodeBlock.GEORGIAN;
import static java.lang.Character.UnicodeBlock.GREEK;
import static java.lang.Character.UnicodeBlock.GREEK_EXTENDED;
import static java.lang.Character.UnicodeBlock.GUJARATI;
import static java.lang.Character.UnicodeBlock.GURMUKHI;
import static java.lang.Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO;
import static java.lang.Character.UnicodeBlock.HANGUL_JAMO;
import static java.lang.Character.UnicodeBlock.HEBREW;
import static java.lang.Character.UnicodeBlock.HIRAGANA;
import static java.lang.Character.UnicodeBlock.IPA_EXTENSIONS;
import static java.lang.Character.UnicodeBlock.KANBUN;
import static java.lang.Character.UnicodeBlock.KANNADA;
import static java.lang.Character.UnicodeBlock.KATAKANA;
import static java.lang.Character.UnicodeBlock.LAO;
import static java.lang.Character.UnicodeBlock.LATIN_1_SUPPLEMENT;
import static java.lang.Character.UnicodeBlock.LATIN_EXTENDED_A;
import static java.lang.Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL;
import static java.lang.Character.UnicodeBlock.LATIN_EXTENDED_B;
import static java.lang.Character.UnicodeBlock.LETTERLIKE_SYMBOLS;
import static java.lang.Character.UnicodeBlock.MALAYALAM;
import static java.lang.Character.UnicodeBlock.MATHEMATICAL_OPERATORS;
import static java.lang.Character.UnicodeBlock.MEETEI_MAYEK_EXTENSIONS;
import static java.lang.Character.UnicodeBlock.MEROITIC_CURSIVE;
import static java.lang.Character.UnicodeBlock.MEROITIC_HIEROGLYPHS;
import static java.lang.Character.UnicodeBlock.MIAO;
import static java.lang.Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS;
import static java.lang.Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS;
import static java.lang.Character.UnicodeBlock.MISCELLANEOUS_TECHNICAL;
import static java.lang.Character.UnicodeBlock.NUMBER_FORMS;
import static java.lang.Character.UnicodeBlock.OPTICAL_CHARACTER_RECOGNITION;
import static java.lang.Character.UnicodeBlock.ORIYA;
import static java.lang.Character.UnicodeBlock.SHARADA;
import static java.lang.Character.UnicodeBlock.SORA_SOMPENG;
import static java.lang.Character.UnicodeBlock.SPACING_MODIFIER_LETTERS;
import static java.lang.Character.UnicodeBlock.SUNDANESE_SUPPLEMENT;
import static java.lang.Character.UnicodeBlock.SUPERSCRIPTS_AND_SUBSCRIPTS;
import static java.lang.Character.UnicodeBlock.TAKRI;
import static java.lang.Character.UnicodeBlock.TAMIL;
import static java.lang.Character.UnicodeBlock.TELUGU;
import static java.lang.Character.UnicodeBlock.THAI;
import static java.lang.Character.UnicodeBlock.TIBETAN;
import static java.lang.Character.UnicodeBlock.TRANSPORT_AND_MAP_SYMBOLS;
import static org.junit.Assert.assertEquals;

import java.awt.Font;
import java.lang.Character.UnicodeBlock;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.steelzack.chartizate.ChartizateFontManager;
import com.steelzack.chartizate.ChartizateFontManagerImpl;

/**
 * 
 * @author joao
 *
 */
public class ChartizateFontManagerImplTest {
	@Test
	public void testGetCharacterWidth() throws Exception {
		final ChartizateFontManager<Font> manager = new ChartizateFontManagerImpl("Arial", 10);

		assertEquals(6, manager.getCharacterWidth('a'));
		assertEquals(7, manager.getCharacterWidth('A'));

	}
	
	@Test
	@Ignore
	public void testGetAllUniCodeBlocksJava8() throws Exception {
		final UnicodeBlock[] testUnicodes = new UnicodeBlock[] { //
				BASIC_LATIN, //
				LATIN_1_SUPPLEMENT, //
				LATIN_EXTENDED_A, //
				LATIN_EXTENDED_B, //
				IPA_EXTENSIONS, //
				SPACING_MODIFIER_LETTERS, //
				COMBINING_DIACRITICAL_MARKS, //
				GREEK, //
				CYRILLIC, //
				ARMENIAN, //
				HEBREW, //
				ARABIC, //
				DEVANAGARI, //
				BENGALI, //
				GURMUKHI, //
				GUJARATI, //
				ORIYA, //
				TAMIL, //
				TELUGU, //
				KANNADA, //
				MALAYALAM, //
				THAI, //
				LAO, //
				TIBETAN, //
				GEORGIAN, //
				HANGUL_JAMO, //
				LATIN_EXTENDED_ADDITIONAL, //
				GREEK_EXTENDED, //
				GENERAL_PUNCTUATION, //
				SUPERSCRIPTS_AND_SUBSCRIPTS, //
				CURRENCY_SYMBOLS, //
				COMBINING_MARKS_FOR_SYMBOLS, //
				LETTERLIKE_SYMBOLS, //
				NUMBER_FORMS, //
				ARROWS, //
				MATHEMATICAL_OPERATORS, //
				MISCELLANEOUS_TECHNICAL, //
				CONTROL_PICTURES, //
				OPTICAL_CHARACTER_RECOGNITION, //
				ENCLOSED_ALPHANUMERICS, //
				BOX_DRAWING, //
				BLOCK_ELEMENTS, //
				GEOMETRIC_SHAPES, //
				MISCELLANEOUS_SYMBOLS, //
				DINGBATS, //
				CJK_SYMBOLS_AND_PUNCTUATION, //
				HIRAGANA, //
				KATAKANA, //
				BOPOMOFO, //
				HANGUL_COMPATIBILITY_JAMO, //
				KANBUN, //
				ENCLOSED_CJK_LETTERS_AND_MONTHS, //
				CJK_COMPATIBILITY, //
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS, //
				UnicodeBlock.HANGUL_SYLLABLES, //
				UnicodeBlock.PRIVATE_USE_AREA, //
				UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS, //
				UnicodeBlock.ALPHABETIC_PRESENTATION_FORMS, //
				UnicodeBlock.ARABIC_PRESENTATION_FORMS_A, //
				UnicodeBlock.COMBINING_HALF_MARKS, //
				UnicodeBlock.CJK_COMPATIBILITY_FORMS, //
				UnicodeBlock.SMALL_FORM_VARIANTS, //
				UnicodeBlock.ARABIC_PRESENTATION_FORMS_B, //
				UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS, //
				UnicodeBlock.SPECIALS, //
				UnicodeBlock.SYRIAC, //
				UnicodeBlock.THAANA, //
				UnicodeBlock.SINHALA, //
				UnicodeBlock.MYANMAR, //
				UnicodeBlock.ETHIOPIC, //
				UnicodeBlock.CHEROKEE, //
				UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS, //
				UnicodeBlock.OGHAM, //
				UnicodeBlock.RUNIC, //
				UnicodeBlock.KHMER, //
				UnicodeBlock.MONGOLIAN, //
				UnicodeBlock.BRAILLE_PATTERNS, //
				UnicodeBlock.CJK_RADICALS_SUPPLEMENT, //
				UnicodeBlock.KANGXI_RADICALS, //
				UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS, //
				UnicodeBlock.BOPOMOFO_EXTENDED, //
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A, //
				UnicodeBlock.YI_SYLLABLES, //
				UnicodeBlock.YI_RADICALS, //
				UnicodeBlock.CYRILLIC_SUPPLEMENTARY, //
				UnicodeBlock.TAGALOG, //
				UnicodeBlock.HANUNOO, //
				UnicodeBlock.BUHID, //
				UnicodeBlock.TAGBANWA, //
				UnicodeBlock.LIMBU, //
				UnicodeBlock.TAI_LE, //
				UnicodeBlock.KHMER_SYMBOLS, //
				UnicodeBlock.PHONETIC_EXTENSIONS, //
				UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A, //
				UnicodeBlock.SUPPLEMENTAL_ARROWS_A, //
				UnicodeBlock.SUPPLEMENTAL_ARROWS_B, //
				UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B, //
				UnicodeBlock.SUPPLEMENTAL_MATHEMATICAL_OPERATORS, //
				UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS, //
				UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS, //
				UnicodeBlock.YIJING_HEXAGRAM_SYMBOLS, //
				UnicodeBlock.VARIATION_SELECTORS, //
				UnicodeBlock.LINEAR_B_SYLLABARY, //
				UnicodeBlock.LINEAR_B_IDEOGRAMS, //
				UnicodeBlock.AEGEAN_NUMBERS, //
				UnicodeBlock.OLD_ITALIC, //
				UnicodeBlock.GOTHIC, //
				UnicodeBlock.UGARITIC, //
				UnicodeBlock.DESERET, //
				UnicodeBlock.SHAVIAN, //
				UnicodeBlock.OSMANYA, //
				UnicodeBlock.CYPRIOT_SYLLABARY, //
				UnicodeBlock.BYZANTINE_MUSICAL_SYMBOLS, //
				UnicodeBlock.MUSICAL_SYMBOLS, //
				UnicodeBlock.TAI_XUAN_JING_SYMBOLS, //
				UnicodeBlock.MATHEMATICAL_ALPHANUMERIC_SYMBOLS, //
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B, //
				UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT, //
				UnicodeBlock.TAGS, //
				UnicodeBlock.VARIATION_SELECTORS_SUPPLEMENT, //
				UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_A, //
				UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_B, //
				UnicodeBlock.HIGH_SURROGATES, //
				UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES, //
				UnicodeBlock.LOW_SURROGATES, //
				UnicodeBlock.ARABIC_SUPPLEMENT, //
				UnicodeBlock.NKO, //
				UnicodeBlock.SAMARITAN, //
				UnicodeBlock.MANDAIC, //
				UnicodeBlock.ETHIOPIC_SUPPLEMENT, //
				UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED, //
				UnicodeBlock.NEW_TAI_LUE, //
				UnicodeBlock.BUGINESE, //
				UnicodeBlock.TAI_THAM, //
				UnicodeBlock.BALINESE, //
				UnicodeBlock.SUNDANESE, //
				UnicodeBlock.BATAK, //
				UnicodeBlock.LEPCHA, //
				UnicodeBlock.OL_CHIKI, //
				UnicodeBlock.VEDIC_EXTENSIONS, //
				UnicodeBlock.PHONETIC_EXTENSIONS_SUPPLEMENT, //
				UnicodeBlock.COMBINING_DIACRITICAL_MARKS_SUPPLEMENT, //
				UnicodeBlock.GLAGOLITIC, //
				UnicodeBlock.LATIN_EXTENDED_C, //
				UnicodeBlock.COPTIC, //
				UnicodeBlock.GEORGIAN_SUPPLEMENT, //
				UnicodeBlock.TIFINAGH, //
				UnicodeBlock.ETHIOPIC_EXTENDED, //
				UnicodeBlock.CYRILLIC_EXTENDED_A, //
				UnicodeBlock.SUPPLEMENTAL_PUNCTUATION, //
				UnicodeBlock.CJK_STROKES, //
				UnicodeBlock.LISU, //
				UnicodeBlock.VAI, //
				UnicodeBlock.CYRILLIC_EXTENDED_B, //
				UnicodeBlock.BAMUM, //
				UnicodeBlock.MODIFIER_TONE_LETTERS, //
				UnicodeBlock.LATIN_EXTENDED_D, //
				UnicodeBlock.SYLOTI_NAGRI, //
				UnicodeBlock.COMMON_INDIC_NUMBER_FORMS, //
				UnicodeBlock.PHAGS_PA, //
				UnicodeBlock.SAURASHTRA, //
				UnicodeBlock.DEVANAGARI_EXTENDED, //
				UnicodeBlock.KAYAH_LI, //
				UnicodeBlock.REJANG, //
				UnicodeBlock.HANGUL_JAMO_EXTENDED_A, //
				UnicodeBlock.JAVANESE, //
				UnicodeBlock.CHAM, //
				UnicodeBlock.MYANMAR_EXTENDED_A, //
				UnicodeBlock.TAI_VIET, //
				UnicodeBlock.ETHIOPIC_EXTENDED_A, //
				UnicodeBlock.MEETEI_MAYEK, //
				UnicodeBlock.HANGUL_JAMO_EXTENDED_B, //
				UnicodeBlock.VERTICAL_FORMS, //
				UnicodeBlock.ANCIENT_GREEK_NUMBERS, //
				UnicodeBlock.ANCIENT_SYMBOLS, //
				UnicodeBlock.PHAISTOS_DISC, //
				UnicodeBlock.LYCIAN, //
				UnicodeBlock.CARIAN, //
				UnicodeBlock.OLD_PERSIAN, //
				UnicodeBlock.IMPERIAL_ARAMAIC, //
				UnicodeBlock.PHOENICIAN, //
				UnicodeBlock.LYDIAN, //
				UnicodeBlock.KHAROSHTHI, //
				UnicodeBlock.OLD_SOUTH_ARABIAN, //
				UnicodeBlock.AVESTAN, //
				UnicodeBlock.INSCRIPTIONAL_PARTHIAN, //
				UnicodeBlock.INSCRIPTIONAL_PAHLAVI, //
				UnicodeBlock.OLD_TURKIC, //
				UnicodeBlock.RUMI_NUMERAL_SYMBOLS, //
				UnicodeBlock.BRAHMI, //
				UnicodeBlock.KAITHI, //
				UnicodeBlock.CUNEIFORM, //
				UnicodeBlock.CUNEIFORM_NUMBERS_AND_PUNCTUATION, //
				UnicodeBlock.EGYPTIAN_HIEROGLYPHS, //
				UnicodeBlock.BAMUM_SUPPLEMENT, //
				UnicodeBlock.KANA_SUPPLEMENT, //
				UnicodeBlock.ANCIENT_GREEK_MUSICAL_NOTATION, //
				UnicodeBlock.COUNTING_ROD_NUMERALS, //
				UnicodeBlock.MAHJONG_TILES, //
				UnicodeBlock.DOMINO_TILES, //
				UnicodeBlock.PLAYING_CARDS, //
				UnicodeBlock.ENCLOSED_ALPHANUMERIC_SUPPLEMENT, //
				UnicodeBlock.ENCLOSED_IDEOGRAPHIC_SUPPLEMENT, //
				UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS, //
				EMOTICONS, //
				TRANSPORT_AND_MAP_SYMBOLS, //
				ALCHEMICAL_SYMBOLS, //
				CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C, //
				CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D, //
				ARABIC_EXTENDED_A, //
				SUNDANESE_SUPPLEMENT, //
				MEETEI_MAYEK_EXTENSIONS, //
				MEROITIC_HIEROGLYPHS, //
				MEROITIC_CURSIVE, //
				SORA_SOMPENG, //
				CHAKMA, //
				SHARADA, //
				TAKRI, //
				MIAO, //
				ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS //
		};
		final ChartizateFontManagerImpl manager = new ChartizateFontManagerImpl("Arial", 10);

		final List<UnicodeBlock> result = manager.getAllUniCodeBlocksJava8();

		Assert.assertArrayEquals(testUnicodes, result.toArray());
	}

	@Test
	public void testGetAllUniCodeBlocksJava7() throws Exception {
		final UnicodeBlock[] testUnicodes = new UnicodeBlock[] { //
				BASIC_LATIN, //
				LATIN_1_SUPPLEMENT, //
				LATIN_EXTENDED_A, //
				LATIN_EXTENDED_B, //
				IPA_EXTENSIONS, //
				SPACING_MODIFIER_LETTERS, //
				COMBINING_DIACRITICAL_MARKS, //
				GREEK, //
				CYRILLIC, //
				ARMENIAN, //
				HEBREW, //
				ARABIC, //
				DEVANAGARI, //
				BENGALI, //
				GURMUKHI, //
				GUJARATI, //
				ORIYA, //
				TAMIL, //
				TELUGU, //
				KANNADA, //
				MALAYALAM, //
				THAI, //
				LAO, //
				TIBETAN, //
				GEORGIAN, //
				HANGUL_JAMO, //
				LATIN_EXTENDED_ADDITIONAL, //
				GREEK_EXTENDED, //
				GENERAL_PUNCTUATION, //
				SUPERSCRIPTS_AND_SUBSCRIPTS, //
				CURRENCY_SYMBOLS, //
				COMBINING_MARKS_FOR_SYMBOLS, //
				LETTERLIKE_SYMBOLS, //
				NUMBER_FORMS, //
				ARROWS, //
				MATHEMATICAL_OPERATORS, //
				MISCELLANEOUS_TECHNICAL, //
				CONTROL_PICTURES, //
				OPTICAL_CHARACTER_RECOGNITION, //
				ENCLOSED_ALPHANUMERICS, //
				BOX_DRAWING, //
				BLOCK_ELEMENTS, //
				GEOMETRIC_SHAPES, //
				MISCELLANEOUS_SYMBOLS, //
				DINGBATS, //
				CJK_SYMBOLS_AND_PUNCTUATION, //
				HIRAGANA, //
				KATAKANA, //
				BOPOMOFO, //
				HANGUL_COMPATIBILITY_JAMO, //
				KANBUN, //
				ENCLOSED_CJK_LETTERS_AND_MONTHS, //
				CJK_COMPATIBILITY, //
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS, //
				UnicodeBlock.HANGUL_SYLLABLES, //
				UnicodeBlock.PRIVATE_USE_AREA, //
				UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS, //
				UnicodeBlock.ALPHABETIC_PRESENTATION_FORMS, //
				UnicodeBlock.ARABIC_PRESENTATION_FORMS_A, //
				UnicodeBlock.COMBINING_HALF_MARKS, //
				UnicodeBlock.CJK_COMPATIBILITY_FORMS, //
				UnicodeBlock.SMALL_FORM_VARIANTS, //
				UnicodeBlock.ARABIC_PRESENTATION_FORMS_B, //
				UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS, //
				UnicodeBlock.SPECIALS, //
				UnicodeBlock.SYRIAC, //
				UnicodeBlock.THAANA, //
				UnicodeBlock.SINHALA, //
				UnicodeBlock.MYANMAR, //
				UnicodeBlock.ETHIOPIC, //
				UnicodeBlock.CHEROKEE, //
				UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS, //
				UnicodeBlock.OGHAM, //
				UnicodeBlock.RUNIC, //
				UnicodeBlock.KHMER, //
				UnicodeBlock.MONGOLIAN, //
				UnicodeBlock.BRAILLE_PATTERNS, //
				UnicodeBlock.CJK_RADICALS_SUPPLEMENT, //
				UnicodeBlock.KANGXI_RADICALS, //
				UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS, //
				UnicodeBlock.BOPOMOFO_EXTENDED, //
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A, //
				UnicodeBlock.YI_SYLLABLES, //
				UnicodeBlock.YI_RADICALS, //
				UnicodeBlock.CYRILLIC_SUPPLEMENTARY, //
				UnicodeBlock.TAGALOG, //
				UnicodeBlock.HANUNOO, //
				UnicodeBlock.BUHID, //
				UnicodeBlock.TAGBANWA, //
				UnicodeBlock.LIMBU, //
				UnicodeBlock.TAI_LE, //
				UnicodeBlock.KHMER_SYMBOLS, //
				UnicodeBlock.PHONETIC_EXTENSIONS, //
				UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A, //
				UnicodeBlock.SUPPLEMENTAL_ARROWS_A, //
				UnicodeBlock.SUPPLEMENTAL_ARROWS_B, //
				UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B, //
				UnicodeBlock.SUPPLEMENTAL_MATHEMATICAL_OPERATORS, //
				UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS, //
				UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS, //
				UnicodeBlock.YIJING_HEXAGRAM_SYMBOLS, //
				UnicodeBlock.VARIATION_SELECTORS, //
				UnicodeBlock.LINEAR_B_SYLLABARY, //
				UnicodeBlock.LINEAR_B_IDEOGRAMS, //
				UnicodeBlock.AEGEAN_NUMBERS, //
				UnicodeBlock.OLD_ITALIC, //
				UnicodeBlock.GOTHIC, //
				UnicodeBlock.UGARITIC, //
				UnicodeBlock.DESERET, //
				UnicodeBlock.SHAVIAN, //
				UnicodeBlock.OSMANYA, //
				UnicodeBlock.CYPRIOT_SYLLABARY, //
				UnicodeBlock.BYZANTINE_MUSICAL_SYMBOLS, //
				UnicodeBlock.MUSICAL_SYMBOLS, //
				UnicodeBlock.TAI_XUAN_JING_SYMBOLS, //
				UnicodeBlock.MATHEMATICAL_ALPHANUMERIC_SYMBOLS, //
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B, //
				UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT, //
				UnicodeBlock.TAGS, //
				UnicodeBlock.VARIATION_SELECTORS_SUPPLEMENT, //
				UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_A, //
				UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_B, //
				UnicodeBlock.HIGH_SURROGATES, //
				UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES, //
				UnicodeBlock.LOW_SURROGATES, //
				UnicodeBlock.ARABIC_SUPPLEMENT, //
				UnicodeBlock.NKO, //
				UnicodeBlock.SAMARITAN, //
				UnicodeBlock.MANDAIC, //
				UnicodeBlock.ETHIOPIC_SUPPLEMENT, //
				UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED, //
				UnicodeBlock.NEW_TAI_LUE, //
				UnicodeBlock.BUGINESE, //
				UnicodeBlock.TAI_THAM, //
				UnicodeBlock.BALINESE, //
				UnicodeBlock.SUNDANESE, //
				UnicodeBlock.BATAK, //
				UnicodeBlock.LEPCHA, //
				UnicodeBlock.OL_CHIKI, //
				UnicodeBlock.VEDIC_EXTENSIONS, //
				UnicodeBlock.PHONETIC_EXTENSIONS_SUPPLEMENT, //
				UnicodeBlock.COMBINING_DIACRITICAL_MARKS_SUPPLEMENT, //
				UnicodeBlock.GLAGOLITIC, //
				UnicodeBlock.LATIN_EXTENDED_C, //
				UnicodeBlock.COPTIC, //
				UnicodeBlock.GEORGIAN_SUPPLEMENT, //
				UnicodeBlock.TIFINAGH, //
				UnicodeBlock.ETHIOPIC_EXTENDED, //
				UnicodeBlock.CYRILLIC_EXTENDED_A, //
				UnicodeBlock.SUPPLEMENTAL_PUNCTUATION, //
				UnicodeBlock.CJK_STROKES, //
				UnicodeBlock.LISU, //
				UnicodeBlock.VAI, //
				UnicodeBlock.CYRILLIC_EXTENDED_B, //
				UnicodeBlock.BAMUM, //
				UnicodeBlock.MODIFIER_TONE_LETTERS, //
				UnicodeBlock.LATIN_EXTENDED_D, //
				UnicodeBlock.SYLOTI_NAGRI, //
				UnicodeBlock.COMMON_INDIC_NUMBER_FORMS, //
				UnicodeBlock.PHAGS_PA, //
				UnicodeBlock.SAURASHTRA, //
				UnicodeBlock.DEVANAGARI_EXTENDED, //
				UnicodeBlock.KAYAH_LI, //
				UnicodeBlock.REJANG, //
				UnicodeBlock.HANGUL_JAMO_EXTENDED_A, //
				UnicodeBlock.JAVANESE, //
				UnicodeBlock.CHAM, //
				UnicodeBlock.MYANMAR_EXTENDED_A, //
				UnicodeBlock.TAI_VIET, //
				UnicodeBlock.ETHIOPIC_EXTENDED_A, //
				UnicodeBlock.MEETEI_MAYEK, //
				UnicodeBlock.HANGUL_JAMO_EXTENDED_B, //
				UnicodeBlock.VERTICAL_FORMS, //
				UnicodeBlock.ANCIENT_GREEK_NUMBERS, //
				UnicodeBlock.ANCIENT_SYMBOLS, //
				UnicodeBlock.PHAISTOS_DISC, //
				UnicodeBlock.LYCIAN, //
				UnicodeBlock.CARIAN, //
				UnicodeBlock.OLD_PERSIAN, //
				UnicodeBlock.IMPERIAL_ARAMAIC, //
				UnicodeBlock.PHOENICIAN, //
				UnicodeBlock.LYDIAN, //
				UnicodeBlock.KHAROSHTHI, //
				UnicodeBlock.OLD_SOUTH_ARABIAN, //
				UnicodeBlock.AVESTAN, //
				UnicodeBlock.INSCRIPTIONAL_PARTHIAN, //
				UnicodeBlock.INSCRIPTIONAL_PAHLAVI, //
				UnicodeBlock.OLD_TURKIC, //
				UnicodeBlock.RUMI_NUMERAL_SYMBOLS, //
				UnicodeBlock.BRAHMI, //
				UnicodeBlock.KAITHI, //
				UnicodeBlock.CUNEIFORM, //
				UnicodeBlock.CUNEIFORM_NUMBERS_AND_PUNCTUATION, //
				UnicodeBlock.EGYPTIAN_HIEROGLYPHS, //
				UnicodeBlock.BAMUM_SUPPLEMENT, //
				UnicodeBlock.KANA_SUPPLEMENT, //
				UnicodeBlock.ANCIENT_GREEK_MUSICAL_NOTATION, //
				UnicodeBlock.COUNTING_ROD_NUMERALS, //
				UnicodeBlock.MAHJONG_TILES, //
				UnicodeBlock.DOMINO_TILES, //
				UnicodeBlock.PLAYING_CARDS, //
				ENCLOSED_ALPHANUMERIC_SUPPLEMENT, //
				ENCLOSED_IDEOGRAPHIC_SUPPLEMENT, //
				MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS, //
				EMOTICONS, //
				TRANSPORT_AND_MAP_SYMBOLS, //
				ALCHEMICAL_SYMBOLS, //
				CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C, //
				CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D, //
		};
		final ChartizateFontManagerImpl manager = new ChartizateFontManagerImpl("Arial", 10);

		final List<UnicodeBlock> result = manager.getAllUniCodeBlocksJava7();

		Assert.assertArrayEquals(testUnicodes, result.toArray());
	}

	@Test
	public void testGetAllDistributionTypes() throws Exception {
		final String[] testDistributions = new String[] { //
				"Linear", //
				"Gaussian", //
				"Poisson", //
				"Skellam" //
		}; //
		final ChartizateFontManagerImpl manager = new ChartizateFontManagerImpl("Arial", 10);

		final List<String> result = manager.getAllDistributionTypes();

		Assert.assertArrayEquals(testDistributions, result.toArray());
	}

	@Test
	public void testGetAllFontTypes() throws Exception {
		final ChartizateFontManagerImpl manager = new ChartizateFontManagerImpl("Arial", 10);
		System.out.println(manager.getAllFontTypes());
	}
}
