package com.steelzack.pencelizer;

import static com.steelzack.pencelizer.distributions.PencelizerDistributionTypes.Linear;

import java.awt.Color;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;

import org.junit.Test;

/**
 * 
 * @author joao
 *
 */
public class PencelizerManagerTest {

	@Test
		public void testAddPencelizerCharacter() throws Exception {
			// TODO: Make Junit test
		}

	@Test
	public void testPencelizerManager() throws Exception {
		// TODO: Make Junit test
	}

	@Test
	public void testGenerateConvertedImage() throws Exception {
		InputStream imageFullStream = getClass().getResourceAsStream("pencelizerCyanBlack.png");
		final PencelizerManager manager = new PencelizerManager( //
				1, //
				Color.BLACK, //
				50, //
				10, //
				Linear, //
				"Arial", // 
				5, //
				UnicodeBlock.LATIN_EXTENDED_A, //
				imageFullStream, //
				"/tmp/test.png" //
		);
		manager.generateConvertedImage();
	}
}
