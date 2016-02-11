package com.steelzack.chartizate;

import java.io.IOException;

import com.steelzack.chartizate.objects.PencelizerCharacterImg;

public interface PencelizerImageManager<T> {

	int getImageWidth();

	int getImageHeight();

	long getImageAverageColor();

	int getPartAverageColor(int x0, int y0, int xn, int yn);

	void saveImage(PencelizerCharacterImg<?>[][] pencelizerBoard, PencelizerFontManager<T> fontManager,
			String outputFile, int outputWidth, int outputHeight) throws IOException;

}