package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.IOException;

public interface ChartizateImageManager<C, F, B> {

    C getImageAverageColor();

    C getPartAverageColor(final int x0, final int y0, final int xn, final int yn);

    int getBlue(int rgbPixel);

    int getGreen(int rgbPixel);

    int getRed(int rgbPixel);

    int getAlpha(int rgbPixel);

    void saveBitmap(B bufferedImage) throws IOException;

    int getImagePixelRGB(int j, int k);

    C createColor(int mediumApha, int mediumRed, int mediumGreen, int mediumBlue);

    int getImageWidth();

    int getImageHeight();

    B generateBufferedImage(ChartizateCharacterImg<C>[][] chartizateCharacterImage, ChartizateFontManager<F> fontManager) throws IOException;
}