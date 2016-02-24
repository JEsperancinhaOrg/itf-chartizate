package com.steelzack.chartizate;

import static com.steelzack.chartizate.distributions.ChartizateDistributionType.Linear;
import static org.junit.Assert.assertNotNull;

import java.awt.Color;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;

import org.junit.Test;

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
		final InputStream imageFullStream = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		assertNotNull(imageFullStream);

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
	public void testGenerateConvertedImage_Latin_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");

		assertNotNull(imageFullStream);

		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.LATIN_EXTENDED_A, //
				imageFullStream, //
				"/tmp/testRealExample2Latin.png" //
		);
		manager.generateConvertedImage();
	}
	@Test
	public void testGenerateConvertedImage_Arabic_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
		
		assertNotNull(imageFullStream);
		
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.ARABIC, //
				imageFullStream, //
				"/tmp/testRealExample2Arabic.png" //
				);
		manager.generateConvertedImage();
	}
	@Test
	public void testGenerateConvertedImage_Hebrew_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
		
		assertNotNull(imageFullStream);
		
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.HEBREW, //
				imageFullStream, //
				"/tmp/testRealExample2Hebrew.png" //
				);
		manager.generateConvertedImage();
	}
	@Test
	public void testGenerateConvertedImage_Syriac_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
		
		assertNotNull(imageFullStream);
		
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.SYRIAC, //
				imageFullStream, //
				"/tmp/testRealExample2Syriac.png" //
				);
		manager.generateConvertedImage();
	}
	@Test
	public void testGenerateConvertedImage__Samaritan_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
		
		assertNotNull(imageFullStream);
		
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.SAMARITAN, //
				imageFullStream, //
				"/tmp/testRealExample2Samaritan.png" //
				);
		manager.generateConvertedImage();
	}
	@Test
	public void testGenerateConvertedImage_Mandaic_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
		
		assertNotNull(imageFullStream);
		
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.MANDAIC, //
				imageFullStream, //
				"/tmp/testRealExample2Mandaic.png" //
				);
		manager.generateConvertedImage();
	}
	@Test
	public void testGenerateConvertedImage_Thaana_RealExample2() throws Exception {
		final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
		
		assertNotNull(imageFullStream);
		
		final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
				Color.BLACK, //
				100, //
				100, //
				Linear, //
				"Times New Roman", //
				20, //
				UnicodeBlock.THAANA, //
				imageFullStream, //
				"/tmp/testRealExample2Thaana.png" //
				);
		manager.generateConvertedImage();
	}
}
