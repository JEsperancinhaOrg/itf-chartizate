package com.steelzack.pencelizer;

import static java.lang.Math.abs;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PencelizerImageManager {

	private BufferedImage srcImage;

	public PencelizerImageManager(InputStream io) throws IOException {
		try {
			BufferedImage image = ImageIO.read(io);
			this.srcImage = image;
		} catch (IOException ex) {
			throw ex;
		}
	}

	public long getImageAverageColor() {
		final int width = srcImage.getWidth() - 1;
		final int height = srcImage.getHeight() - 1;
		return getPartAverageColor(0, 0, width, height);
	}

	public int getPartAverageColor(final int x0, final int y0, final int xn, final int yn) {
		double alpha = 0;
		double red = 0;
		double green = 0;
		double blue = 0;
		for (int j = x0; j <= xn; j++) {
			for (int k = y0; k <= yn; k++) {
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
		
		int fullSum = new Color(mediumRed, mediumGreen, mediumBlue, mediumApha).getRGB();
		return fullSum;
	}
}
