package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.IOException;
import java.util.stream.IntStream;

public interface ChartizateImageManager<C, F, B> {

    C getImageAverageColor();

    C getPartAverageColor(IntStream x, IntStream y);

    int getBlue(int rgbPixel);

    int getGreen(int rgbPixel);

    int getRed(int rgbPixel);

    int getAlpha(int rgbPixel);

    void saveBitmap(B bufferedImage) throws IOException;

    B generateBufferedImage(ChartizateCharacterImg<C>[][] chartizateCharacterImage, ChartizateFontManager<F> fontManager) throws IOException;

    ChartizateImage<C> getSrcImage();
}