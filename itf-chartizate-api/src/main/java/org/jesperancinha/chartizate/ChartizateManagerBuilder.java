package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;

import java.io.IOException;
import java.io.InputStream;

public interface ChartizateManagerBuilder<C, F, B> {

    ChartizateFontManager<F> createFontManager(final String fontName, final int fontSize);

    ChartizateEncodingManager<F> createEncodingManager(final Character.UnicodeBlock block);

    ChartizateImageManager<C, F, B> createImageManager(final InputStream imageFullStream) throws IOException;

    ChartizateManagerBuilder<C, F, B> withFontManager(String fontName, int fontSize);

    ChartizateManagerBuilder<C, F, B> withBackground(C background);

    ChartizateManagerBuilder<C, F, B> withDistribution(ChartizateDistributionType distributionType, int densityPercentage, int rangePercentage);

    ChartizateManagerBuilder<C, F, B> withEncodingManager(Character.UnicodeBlock block);

    ChartizateManagerBuilder<C, F, B> withImageManager(InputStream imageFullStream) throws IOException;

    ChartizateManagerBuilder<C, F, B> withChartizateBoard();

    ChartizateManagerBuilder<C, F, B> withDestinationPath(String destinationImagePath);

    ChartizateManagerBuilder<C, F, B> backgroundColor(C backgroundColor);

    ChartizateManagerBuilder<C, F, B> densityPercentage(int densityPercentage);

    ChartizateManagerBuilder<C, F, B> rangePercentage(int rangePercentage);

    ChartizateManagerBuilder<C, F, B> distributionType(ChartizateDistributionType distributionType);

    ChartizateManagerBuilder<C, F, B> fontName(String fontName);

    ChartizateManagerBuilder<C, F, B> fontSize(int fontSize);

    ChartizateManagerBuilder<C, F, B> block(Character.UnicodeBlock block);

    ChartizateManagerBuilder<C, F, B> imageFullStream(InputStream imageFullStream) throws IOException;

    ChartizateManagerBuilder<C, F, B> destinationImagePath(String destinationImagePath);

    ChartizateManager<C, F, B> build() throws IOException;
}