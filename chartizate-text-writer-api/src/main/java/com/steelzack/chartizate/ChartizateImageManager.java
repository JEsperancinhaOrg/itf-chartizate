package com.steelzack.chartizate;

import java.io.IOException;

import com.steelzack.chartizate.objects.ChartizateCharacterImg;

public abstract class ChartizateImageManager<COLOR, FONT> {

	abstract int getImageWidth();

	abstract int getImageHeight();

	abstract COLOR getPartAverageColor(int x0, int y0, int xn, int yn);

	abstract void saveImage(ChartizateCharacterImg<?>[][] pencelizerBoard, ChartizateFontManager<FONT> fontManager,
			String outputFile, int outputWidth, int outputHeight) throws IOException;

	public COLOR getImageAverageColor() {
		final int width = getImageWidth() - 1;
		final int height = getImageHeight() - 1;
		return getPartAverageColor(0, 0, width, height);
	}
}