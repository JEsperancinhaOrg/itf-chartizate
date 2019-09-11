package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionAbstract;
import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import org.jesperancinha.chartizate.distributions.ChartizateLinearDistributionImpl;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImgImpl;

import java.io.IOException;
import java.io.InputStream;

public abstract class ChartizateManagerBuilderAbstract<C, F, B> implements ChartizateManagerBuilder<C, F, B> {
    protected ChartizateCharacterImg<C>[][] chartizateBoard;
    protected ChartizateFontManager<F> fontManager;
    protected C background;
    protected ChartizateDistributionAbstract distribution;
    protected ChartizateEncodingManager<F> encodingManager;
    protected ChartizateImageManager<C, F, B> imageManager;
    protected String destinationImagePath;

    public abstract ChartizateFontManager<F> createFontManager(final String fontName, final int fontSize);

    public abstract ChartizateEncodingManager<F> createEncodingManager(final Character.UnicodeBlock block);

    public abstract ChartizateImageManager<C, F, B> createImageManager(final InputStream imageFullStream) throws IOException;

    public ChartizateManagerBuilder<C, F, B> withFontManager(String fontName, int fontSize) {
        this.fontManager = createFontManager(fontName, fontSize);
        return this;
    }

    public ChartizateManagerBuilder<C, F, B> withBackground(C background) {
        this.background = background;
        return this;
    }

    public ChartizateManagerBuilder<C, F, B> withDistribution(ChartizateDistributionType distributionType, int densityPercentage, int rangePercentage) {
        this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
        return this;
    }

    public ChartizateManagerBuilder<C, F, B> withEncodingManager(Character.UnicodeBlock block) {
        this.encodingManager = createEncodingManager(block);
        this.encodingManager.init();
        return this;
    }

    public ChartizateManagerBuilder<C, F, B> withImageManager(InputStream imageFullStream) throws IOException {
        this.imageManager = createImageManager(imageFullStream);
        return this;
    }

    public ChartizateManagerBuilder<C, F, B> withChartizateBoard() {
        final int imageHeight = imageManager.getImageHeight();
        this.chartizateBoard = new ChartizateCharacterImg[imageHeight / fontManager.getFontSize()][];
        return this;
    }

    public ChartizateManagerBuilder<C, F, B> withDestinationPath(String destinationImagePath) {
        this.destinationImagePath = destinationImagePath;
        return this;
    }

    private ChartizateDistributionAbstract getDistribution(
            ChartizateDistributionType distributionType,
            int densityPercentage,
            int rangePercentage
    ) {
        switch (distributionType) {
            case Linear:
                return new ChartizateLinearDistributionImpl(
                        this.encodingManager.getCharacters(),
                        densityPercentage,
                        rangePercentage
                );
            case Gaussian:
            case Poisson:
            default:
                return null; //TODO: To be implemented
        }
    }

    public abstract ChartizateManagerBuilder<C, F, B> backgroundColor(C backgroundColor);

    public abstract ChartizateManagerBuilder<C, F, B> densityPercentage(int densityPercentage);

    public abstract ChartizateManagerBuilder<C, F, B> rangePercentage(int rangePercentage);

    public abstract ChartizateManagerBuilder<C, F, B> distributionType(ChartizateDistributionType distributionType);

    public abstract ChartizateManagerBuilder<C, F, B> fontName(String fontName);

    public abstract ChartizateManagerBuilder<C, F, B> fontSize(int fontSize);

    public abstract ChartizateManagerBuilder<C, F, B> block(Character.UnicodeBlock block);

    public abstract ChartizateManagerBuilder<C, F, B> imageFullStream(InputStream imageFullStream) throws IOException;

    public abstract ChartizateManagerBuilder<C, F, B> destinationImagePath(String destinationImagePath);

    public abstract ChartizateManager<C, F, B> build() throws IOException;
}