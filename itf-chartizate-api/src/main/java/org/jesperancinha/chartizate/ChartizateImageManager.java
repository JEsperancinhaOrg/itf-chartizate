package org.jesperancinha.chartizate;

import com.google.common.annotations.VisibleForTesting;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.IOException;

public abstract class ChartizateImageManager<C, F, B> {

    @VisibleForTesting
    abstract int getImageWidth();

    @VisibleForTesting
    abstract int getImageHeight();

    @VisibleForTesting
    abstract B saveImage(ChartizateCharacterImg<?>[][] chartizateCharacterImage, ChartizateFontManager<F> fontManager,
                         String outputFile, int outputWidth, int outputHeight) throws IOException;

    public C getImageAverageColor() {
        final int width = getImageWidth() - 1;
        final int height = getImageHeight() - 1;
        return getPartAverageColor(0, 0, width, height);
    }

    public C getPartAverageColor(final int x0, final int y0, final int xn, final int yn) {
        double alpha = 0;
        double red = 0;
        double green = 0;
        double blue = 0;
        for (int j = x0; j <= xn && j < getImageWidth(); j++) {
            for (int k = y0; k <= yn && k < getImageHeight(); k++) {
                int rgbPixel = getImagePixelRGB(j, k);
                alpha += getAlpha(rgbPixel);
                red += getRed(rgbPixel);
                green += getGreen(rgbPixel);
                blue += getBlue(rgbPixel);
            }
        }

        int commonDenominator = (xn - x0 + 1) * (yn - y0 + 1);
        int mediumApha = (int) (alpha / commonDenominator);
        int mediumRed = (int) (red / commonDenominator);
        int mediumBlue = (int) (blue / commonDenominator);
        int mediumGreen = (int) (green / commonDenominator);

        return createColor(mediumApha, mediumRed, mediumGreen, mediumBlue);
    }

    @VisibleForTesting
    abstract int getBlue(int rgbPixel);

    @VisibleForTesting
    abstract int getGreen(int rgbPixel);

    @VisibleForTesting
    abstract int getRed(int rgbPixel);

    @VisibleForTesting
    abstract int getAlpha(int rgbPixel);

    @VisibleForTesting
    abstract int getImagePixelRGB(int j, int k);

    @VisibleForTesting
    abstract C createColor(int mediumApha, int mediumRed, int mediumGreen, int mediumBlue);
}