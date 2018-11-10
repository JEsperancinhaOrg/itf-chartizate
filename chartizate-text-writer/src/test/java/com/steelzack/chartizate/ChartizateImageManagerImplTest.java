package com.jesperancinha.chartizate;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;

import org.junit.Test;

import com.jesperancinha.chartizate.ChartizateFontManager;
import com.jesperancinha.chartizate.ChartizateFontManagerImpl;
import com.jesperancinha.chartizate.ChartizateImageManager;
import com.jesperancinha.chartizate.ChartizateImageManagerImpl;
import com.jesperancinha.chartizate.objects.ChartizateCharacterImg;

/**
 * 
 * @author joao
 *
 */
public class ChartizateImageManagerImplTest {

	@Test
	public void testGetImageAverageColor_BlackGreen() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerBlackGreen.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		assertEquals(-13788928, imageManager.getImageAverageColor());
	}

	@Test
	public void testGetImageAverageColor_CyanBlack() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		assertEquals(-16742778, imageManager.getImageAverageColor());
	}

	@Test
	public void testGetPartAverageColor_CyanBlack00() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		assertEquals(-16728129, imageManager.getPartAverageColor(0, 0, 10, 10));
	}

	@Test
	public void testGetPartAverageColor_CyanBlack10() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		assertEquals(-16759226, imageManager.getPartAverageColor(10, 0, 19, 10));
	}

	@Test
	public void testSaveImage() throws Exception {
		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl();
		final ChartizateCharacterImg<?>[][] pencelizerBoard = new ChartizateCharacterImg[2][];
		pencelizerBoard[0] = new ChartizateCharacterImg[] { //
				new ChartizateCharacterImg<Color>(Color.GREEN, Color.BLACK, 10, 'A'), //
				new ChartizateCharacterImg<Color>(Color.RED, Color.BLACK, 10, 'B') //
		};
		pencelizerBoard[1] = new ChartizateCharacterImg[] { //
				new ChartizateCharacterImg<Color>(Color.BLUE, Color.BLACK, 10, 'C'), //
				new ChartizateCharacterImg<Color>(Color.YELLOW, Color.BLACK, 10, 'D') //
		};
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);

		final String outputFile = "/tmp/saveImage.png";
		final int outputWidth = 20;
		final int outputHeight = 20;
		imageManager.saveImage(pencelizerBoard, fontManager, outputFile, outputWidth, outputHeight);
	}
}
