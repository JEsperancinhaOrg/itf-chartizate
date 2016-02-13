package com.steelzack.chartizate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.steelzack.chartizate.ChartizateFontManager;
import com.steelzack.chartizate.ChartizateImageManager;
import com.steelzack.chartizate.objects.ChartizateCharacterImg;

/**
 * 
 * @author joao
 *
 */
public class ChartizateImageManagerImpl extends ChartizateImageManager<Color, Font> {

	private BufferedImage srcImage;

	public ChartizateImageManagerImpl() {
		// For testing purposes only
	}

	public ChartizateImageManagerImpl(InputStream io) throws IOException {
		this.srcImage = ImageIO.read(io);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.steelzack.pencelizer.PencelizerImageManager#getImageWidth()
	 */
	@Override
	public int getImageWidth() {
		return this.srcImage.getWidth();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.steelzack.pencelizer.PencelizerImageManager#getImageHeight()
	 */
	@Override
	public int getImageHeight() {
		return this.srcImage.getHeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.steelzack.pencelizer.PencelizerImageManager#getPartAverageColor(int,
	 * int, int, int)
	 */
	@Override
	public Color getPartAverageColor(final int x0, final int y0, final int xn, final int yn) {
		double alpha = 0;
		double red = 0;
		double green = 0;
		double blue = 0;
		for (int j = x0; j <= xn && j < srcImage.getWidth(); j++) {
			for (int k = y0; k <= yn && k < srcImage.getHeight(); k++) {
				int rgbPixel = srcImage.getRGB(j, k);
				alpha += (rgbPixel >> 24) & 0xff;
				red += (rgbPixel >> 16) & 0xff;
				green += (rgbPixel >> 8) & 0xff;
				blue += (rgbPixel) & 0xff;
			}
		}

		int commonDenominator = (xn - x0 + 1) * (yn - y0 + 1);
		int mediumApha = (int) (alpha / commonDenominator);
		int mediumRed = (int) (red / commonDenominator);
		int mediumBlue = (int) (blue / commonDenominator);
		int mediumGreen = (int) (green / commonDenominator);

		return new Color(mediumRed, mediumGreen, mediumBlue, mediumApha);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.steelzack.pencelizer.PencelizerImageManager#saveImage(com.steelzack.
	 * pencelizer.PencelizerCharacterImg,
	 * com.steelzack.pencelizer.PencelizerFontManager, java.lang.String, int,
	 * int)
	 */
	@Override
	public void saveImage(ChartizateCharacterImg<?>[][] pencelizerBoard, ChartizateFontManager<Font> fontManager,
			String outputFile, int outputWidth, int outputHeight) throws IOException {
		final BufferedImage bImg = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB);
		final Graphics2D g2d = bImg.createGraphics();
		final Font font = fontManager.getFont();
		g2d.setFont(font);

		int currentWidth = 0;
		for (int i = 0; i < pencelizerBoard.length; i++) {
			int rowLength = pencelizerBoard[i].length;
			for (int j = 0; j < rowLength; j++) {
				final ChartizateCharacterImg<?> character = pencelizerBoard[i][j];
				g2d.setColor((Color) character.getFg());
				g2d.drawString(character.toString(), currentWidth, font.getSize() * (i + 1));
				currentWidth += pencelizerBoard[i][j].getWidth();
			}
			currentWidth = 0;
		}
		g2d.dispose();

		if (ImageIO.write(bImg, "png", new File(outputFile))) {
			System.out.println(outputFile + " is saved");
		}
	}
}
