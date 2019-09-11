package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.IOException;
import java.util.stream.IntStream;

public abstract class ChartizateImageManagerAbstract<C, F, B> implements ChartizateImageManager<C, F, B> {

    public class ColorHelper {
        double alpha = 0;
        double red = 0;
        double green = 0;
        double blue = 0;

        public void addPixel(int imagePixelRGB) {
            this.alpha += getAlpha(imagePixelRGB);
            this.red += getRed(imagePixelRGB);
            this.green += getGreen(imagePixelRGB);
            this.blue += getBlue(imagePixelRGB);
        }

        public void divideByDenominator(int commonDenominator) {
            this.alpha = this.alpha / commonDenominator;
            this.red = this.red / commonDenominator;
            this.green = this.green / commonDenominator;
            this.blue = this.blue / commonDenominator;
        }
    }

    public C getImageAverageColor() {
        final int width = getImageWidth() - 1;
        final int height = getImageHeight() - 1;
        return getPartAverageColor(IntStream.range(0, width), IntStream.range(0, height));
    }

    public C getPartAverageColor(IntStream x, IntStream y) {
        final ColorHelper colorHelper = new ColorHelper();
        x.boxed()
                .forEach(j -> y.boxed()
                        .forEach(k -> colorHelper.addPixel(getImagePixelRGB(j, k))));
        final int commonDenominator =
                (x.max().orElse(0) - x.min().orElse(0) + 1) *
                        (y.max().orElse(0) - y.min().orElse(0) + 1);
        colorHelper.divideByDenominator(commonDenominator);
        return createColor(colorHelper);
    }

    public abstract int getBlue(int rgbPixel);

    public abstract int getGreen(int rgbPixel);

    public abstract int getRed(int rgbPixel);

    public abstract int getAlpha(int rgbPixel);

    public abstract void saveBitmap(B bufferedImage) throws IOException;

    public abstract int getImagePixelRGB(int j, int k);

    public abstract C createColor(double mediumApha, double mediumRed, double mediumGreen, double mediumBlue);

    public abstract int getImageWidth();

    public abstract int getImageHeight();

    public abstract B generateBufferedImage(ChartizateCharacterImg<C>[][] chartizateCharacterImage, ChartizateFontManager<F> fontManager) throws IOException;
}