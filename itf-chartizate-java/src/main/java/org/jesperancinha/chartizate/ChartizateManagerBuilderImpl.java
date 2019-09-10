package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class ChartizateManagerBuilderImpl extends ChartizateManagerBuilderAbstract<Color, Font, BufferedImage> {

    private int densityPercentage;
    private int rangePercentage;

    private String fontName;
    private ChartizateDistributionType distributionType;

    @Override
    protected ChartizateImageManagerImpl createImageManager(
            final InputStream imageFullStream) throws IOException {
        return new ChartizateImageManagerImpl(imageFullStream);
    }

    @Override
    protected ChartizateEncodingManagerImpl createEncodingManager(final Character.UnicodeBlock block) {
        return new ChartizateEncodingManagerImpl(block, fontManager);
    }

    @Override
    protected ChartizateFontManagerImpl createFontManager(final String fontName, final int fontSize) {
        return new ChartizateFontManagerImpl(fontName, fontSize);
    }

    public ChartizateManagerBuilderImpl backgroundColor(Color backgroundColor) {
        this.withBackground(backgroundColor);
        return this;
    }

    public ChartizateManagerBuilderImpl densityPercentage(int densityPercentage) {
        this.densityPercentage = densityPercentage;
        return this;
    }

    public ChartizateManagerBuilderImpl rangePercentage(int rangePercentage) {
        this.rangePercentage = rangePercentage;
        return this;
    }

    public ChartizateManagerBuilderImpl distributionType(ChartizateDistributionType distributionType) {
        this.distributionType = distributionType;
        return this;
    }

    public ChartizateManagerBuilderImpl fontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    public ChartizateManagerBuilderImpl fontSize(int fontSize) {
        this.withFontManager(this.fontName, fontSize);
        return this;
    }

    public ChartizateManagerBuilderImpl block(Character.UnicodeBlock block) {
        this.withEncodingManager(block);
        return this;
    }

    public ChartizateManagerBuilderImpl imageFullStream(InputStream imageFullStream) throws IOException {
        this.withImageManager(imageFullStream);
        return this;
    }

    public ChartizateManagerBuilderImpl destinationImagePath(String destinationImagePath) {
        this.withDestinationPath(destinationImagePath);
        return this;
    }

    public ChartizateManager<Color, Font, BufferedImage> build() {
        this.withDistribution(this.distributionType, this.densityPercentage, this.rangePercentage);
        this.withChartizateBoard();
        return ChartizateManager.<Color, Font, BufferedImage>builder()
                .chartizateBoard(super.chartizateBoard)
                .fontManager(this.fontManager)
                .background(this.background)
                .distribution(this.distribution)
                .encodingManager(this.encodingManager)
                .imageManager(this.imageManager)
                .destinationImagePath(this.destinationImagePath)
                .build();
    }
}