package com.jesperancinha.chartizate;

import static com.google.common.truth.Truth.assertThat;

import java.awt.*;
import java.io.InputStream;

import com.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.junit.Test;

/**
 * @author joao
 */
public class ChartizateImageManagerImplTest {

	@Test
	public void testGetImageAverageColor_BlackGreen() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerBlackGreen.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		final Color imageAverageColor = imageManager.getImageAverageColor();
		assertThat(imageAverageColor.getRed()).isEqualTo(45);
		assertThat(imageAverageColor.getGreen()).isEqualTo(153);
		assertThat(imageAverageColor.getBlue()).isEqualTo(0);
	}

	@Test
	public void testGetImageAverageColor_CyanBlack() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		final Color imageAverageColor = imageManager.getImageAverageColor();
		assertThat(imageAverageColor.getRed()).isEqualTo(0);
		assertThat(imageAverageColor.getGreen()).isEqualTo(134);
		assertThat(imageAverageColor.getBlue()).isEqualTo(134);
	}

	@Test
	public void testGetPartAverageColor_CyanBlack00() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		final Color partAverageColor = imageManager.getPartAverageColor(0, 0, 10, 10);

		assertThat(partAverageColor.getRed()).isEqualTo(0);
		assertThat(partAverageColor.getGreen()).isEqualTo(191);
		assertThat(partAverageColor.getBlue()).isEqualTo(191);

	}

	@Test
	public void testGetPartAverageColor_CyanBlack10() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl(io);

		final Color partAverageColor = imageManager.getPartAverageColor(10, 0, 19, 10);
		assertThat(partAverageColor.getRed()).isEqualTo(0);
		assertThat(partAverageColor.getGreen()).isEqualTo(70);
		assertThat(partAverageColor.getBlue()).isEqualTo(70);
	}

	@Test
	public void testSaveImage() throws Exception {
		final ChartizateImageManager<Color, Font> imageManager = new ChartizateImageManagerImpl();
		final ChartizateCharacterImg<?>[][] pencelizerBoard = new ChartizateCharacterImg[2][];
		pencelizerBoard[0] = new ChartizateCharacterImg[] { //
				new ChartizateCharacterImg<>(Color.GREEN, Color.BLACK, 10, 'A'), //
				new ChartizateCharacterImg<>(Color.RED, Color.BLACK, 10, 'B') //
		};
		pencelizerBoard[1] = new ChartizateCharacterImg[] { //
				new ChartizateCharacterImg<>(Color.BLUE, Color.BLACK, 10, 'C'), //
				new ChartizateCharacterImg<>(Color.YELLOW, Color.BLACK, 10, 'D') //
		};
		final ChartizateFontManager<Font> fontManager = new ChartizateFontManagerImpl("Arial", 10);

		final String outputFile = "/tmp/saveImage.png";
		final int outputWidth = 20;
		final int outputHeight = 20;
		imageManager.saveImage(pencelizerBoard, fontManager, outputFile, outputWidth, outputHeight);
	}
}
