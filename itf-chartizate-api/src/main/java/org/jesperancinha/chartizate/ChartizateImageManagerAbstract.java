package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.jesperancinha.chartizate.objects.ColorHelper;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;

public abstract class ChartizateImageManagerAbstract<C, F, B> implements ChartizateImageManager<C, F, B> {

    public void addPixel(ColorHelper colorHelper, int imagePixelRGB) {
        colorHelper.addAlpha(getAlpha(imagePixelRGB));
        colorHelper.addRed(getRed(imagePixelRGB));
        colorHelper.addGreen(getGreen(imagePixelRGB));
        colorHelper.addBlue(getBlue(imagePixelRGB));
    }

    public C getImageAverageColor() {
        final int width = getImageWidth() - 1;
        final int height = getImageHeight() - 1;
        return getPartAverageColor(
                IntStream.range(0, width + 1),
                IntStream.range(0, height + 1));
    }

    public C getPartAverageColor(IntStream x, IntStream y) {
        final IntSummaryStatistics statsY = getStats(y);
        final int y0 = statsY.getMin();
        final int yn = min(statsY.getMax() + 1, getImageHeight());
        final IntSummaryStatistics statsX = getStats(x);
        final int x0 = statsX.getMin();
        final int xn = min(statsX.getMax() + 1, getImageWidth());
        final ColorHelper colorHelper = new ColorHelper();
        IntStream.range(x0, xn).boxed()
                .forEach(j ->
                        IntStream.range(y0, yn).boxed()
                                .forEach(k ->
                                        addPixel(colorHelper, getImagePixelRGB(j, k))));
        final int commonDenominator = (xn - x0 + 1) * (yn - y0 + 1);
        colorHelper.divideByDenominator(commonDenominator);
        return createColor(colorHelper);
    }

    private IntSummaryStatistics getStats(IntStream intStream) {
        return intStream.boxed()
                .collect(Collectors.summarizingInt(Integer::intValue));
    }

    public abstract int getBlue(int rgbPixel);

    public abstract int getGreen(int rgbPixel);

    public abstract int getRed(int rgbPixel);

    public abstract int getAlpha(int rgbPixel);

    public abstract void saveBitmap(B bufferedImage) throws IOException;

    public abstract int getImagePixelRGB(int j, int k);

    public abstract int getImageWidth();

    public abstract int getImageHeight();

    public abstract C createColor(ColorHelper colorHelper);

    public abstract B generateBufferedImage(ChartizateCharacterImg<C>[][] chartizateCharacterImage, ChartizateFontManager<F> fontManager) throws IOException;
}