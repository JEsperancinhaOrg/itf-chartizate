package com.steelzack.chartizate;

import java.io.IOException;

import com.steelzack.chartizate.objects.ChartizateCharacterImg;

public abstract class ChartizateImageManager<COLOR, FONT> {

	abstract int getImageWidth();

	abstract int getImageHeight();

	abstract void saveImage(ChartizateCharacterImg<?>[][] pencelizerBoard, ChartizateFontManager<FONT> fontManager,
			String outputFile, int outputWidth, int outputHeight) throws IOException;

	public COLOR getImageAverageColor() {
		final int width = getImageWidth() - 1;
		final int height = getImageHeight() - 1;
		return getPartAverageColor(0, 0, width, height);
	}
	
	public COLOR getPartAverageColor(final int x0, final int y0, final int xn, final int yn) {
		double alpha = 0;
		double red = 0;
		double green = 0;
		double blue = 0;
		for (int j = x0; j <= xn && j < getImageWidth(); j++) {
			for (int k = y0; k <= yn && k < getImageHeight(); k++) {
				int rgbPixel = getImagePixelRGB(j, k);
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

		return createColor(mediumApha, mediumRed, mediumBlue, mediumGreen);
	}

	abstract int getImagePixelRGB(int j, int k);

	abstract COLOR createColor(int mediumApha, int mediumRed, int mediumBlue, int mediumGreen);
}