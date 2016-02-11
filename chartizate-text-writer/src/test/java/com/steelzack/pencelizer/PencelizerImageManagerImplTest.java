package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;

import org.junit.Test;

/**
 * 
 * @author joao
 *
 */
public class PencelizerImageManagerImplTest {

	@Test
	public void testGetImageAverageColor_BlackGreen() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerBlackGreen.png");

		final PencelizerImageManager<Font> imageManager = new PencelizerImageManagerImpl(io);

		assertEquals(-13788928, imageManager.getImageAverageColor());
	}

	@Test
	public void testGetImageAverageColor_CyanBlack() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final PencelizerImageManager<Font> imageManager = new PencelizerImageManagerImpl(io);

		assertEquals(-16742778, imageManager.getImageAverageColor());
	}

	@Test
	public void testGetPartAverageColor_CyanBlack00() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final PencelizerImageManager<Font> imageManager = new PencelizerImageManagerImpl(io);

		assertEquals(-16728129, imageManager.getPartAverageColor(0, 0, 10, 10));
	}

	@Test
	public void testGetPartAverageColor_CyanBlack10() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final PencelizerImageManager<Font> imageManager = new PencelizerImageManagerImpl(io);

		assertEquals(-16759226, imageManager.getPartAverageColor(10, 0, 19, 10));
	}

	@Test
	public void testSaveImage() throws Exception {
		final PencelizerImageManager<Font> imageManager = new PencelizerImageManagerImpl();
		final PencelizerCharacterImg<?>[][] pencelizerBoard = new PencelizerCharacterImg[2][];
		pencelizerBoard[0] = new PencelizerCharacterImg[] { //
				new PencelizerCharacterImg<Color>(Color.GREEN, Color.BLACK, 10, 'A'), //
				new PencelizerCharacterImg<Color>(Color.RED, Color.BLACK, 10, 'B') //
		};
		pencelizerBoard[1] = new PencelizerCharacterImg[] { //
				new PencelizerCharacterImg<Color>(Color.BLUE, Color.BLACK, 10, 'C'), //
				new PencelizerCharacterImg<Color>(Color.YELLOW, Color.BLACK, 10, 'D') //
		};
		final PencelizerFontManager<Font> fontManager =new PencelizerFontManagerImpl("Arial", 10);
		
		final String outputFile = "/tmp/saveImage.png";
		final int outputWidth = 20;
		final int outputHeight = 20;
		imageManager.saveImage(pencelizerBoard, fontManager, outputFile, outputWidth, outputHeight);
	}
}
