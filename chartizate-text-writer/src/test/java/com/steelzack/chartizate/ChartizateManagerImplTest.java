	package com.steelzack.chartizate;

import static com.steelzack.chartizate.distributions.ChartizateDistributionType.Linear;

import java.awt.Color;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;

import org.junit.Test;

import com.steelzack.chartizate.ChartizateManagerImpl;

/**
 * 
 * @author joao
 *
 */
public class ChartizateManagerImplTest {

	@Test
		public void testAddPencelizerCharacter() throws Exception {
			// TODO: Make Junit test
		}

	@Test
	public void testPencelizerManager() throws Exception {
		// TODO: Make Junit test
	}

	@Test
	public void testGenerateConvertedImage_CyanBlack() throws Exception {
		InputStream imageFullStream = getClass().getResourceAsStream("pencelizerCyanBlack.png");
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				50, //
				10, //
				Linear, //
				"Arial", // 
				5, //
				UnicodeBlock.LATIN_EXTENDED_A, //
				imageFullStream, //
				"/tmp/testCyanBlue.png" //
		);
		manager.generateConvertedImage();
	}
	
	@Test
	public void testGenerateConvertedImage_RealExample1() throws Exception {
		InputStream imageFullStream = getClass().getResourceAsStream("RealExample1.jpg");
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", // 
				20, //
				UnicodeBlock.LATIN_EXTENDED_A, //
				imageFullStream, //
				"/tmp/testRealExample1.png" //
				);
		manager.generateConvertedImage();
	}
}
