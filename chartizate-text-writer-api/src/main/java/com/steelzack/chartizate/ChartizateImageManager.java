package com.steelzack.chartizate;

import java.io.IOException;

import com.steelzack.chartizate.objects.ChartizateCharacterImg;

public interface ChartizateImageManager<T> {

	int getImageWidth();

	int getImageHeight();

	long getImageAverageColor();

	int getPartAverageColor(int x0, int y0, int xn, int yn);

	void saveImage(ChartizateCharacterImg<?>[][] pencelizerBoard, ChartizateFontManager<T> fontManager,
			String outputFile, int outputWidth, int outputHeight) throws IOException;

}