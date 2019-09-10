package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.distributions.ChartizateDistribution;
import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import org.jesperancinha.chartizate.distributions.ChartizateLinearDistribution;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.IOException;
import java.io.InputStream;

public abstract class ChartizateManagerBuilderAbstract<C, F, B> {
    protected ChartizateCharacterImg<C>[][] chartizateBoard;
    protected ChartizateFontManager<F> fontManager;
    protected C background;
    protected ChartizateDistribution distribution;
    protected ChartizateEncodingManager<F> encodingManager;
    protected ChartizateImageManager<C, F, B> imageManager;
    protected String destinationImagePath;

    abstract ChartizateFontManager<F> createFontManager(final String fontName, final int fontSize);

    abstract ChartizateEncodingManager<F> createEncodingManager(final Character.UnicodeBlock block);

    abstract ChartizateImageManager<C, F, B> createImageManager(final InputStream imageFullStream) throws IOException;

    protected ChartizateManagerBuilderAbstract<C, F, B> withFontManager(String fontName, int fontSize) {
        this.fontManager = createFontManager(fontName, fontSize);
        return this;
    }

    protected ChartizateManagerBuilderAbstract<C, F, B> withBackground(C background) {
        this.background = background;
        return this;
    }

    protected ChartizateManagerBuilderAbstract<C, F, B> withDistribution(ChartizateDistributionType distributionType, int densityPercentage, int rangePercentage) {
        this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
        return this;
    }

    protected ChartizateManagerBuilderAbstract<C, F, B> withEncodingManager(Character.UnicodeBlock block) {
        this.encodingManager = createEncodingManager(block);
        this.encodingManager.init();
        return this;
    }

    protected ChartizateManagerBuilderAbstract<C, F, B> withImageManager(InputStream imageFullStream) throws IOException {
        this.imageManager = createImageManager(imageFullStream);
        return this;
    }

    protected ChartizateManagerBuilderAbstract<C, F, B> withChartizateBoard() {
        final int imageHeight = imageManager.getImageHeight();
        this.chartizateBoard = new ChartizateCharacterImg[imageHeight / fontManager.getFontSize()][];
        return this;
    }

    protected ChartizateManagerBuilderAbstract<C, F, B> withDestinationPath(String destinationImagePath) {
        this.destinationImagePath = destinationImagePath;
        return this;
    }

    private ChartizateDistribution getDistribution(
            ChartizateDistributionType distributionType,
            int densityPercentage,
            int rangePercentage
    ) {
        switch (distributionType) {
            case Linear:
                return new ChartizateLinearDistribution(
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

    public abstract ChartizateManagerBuilderAbstract<C, F, B> backgroundColor(C backgroundColor);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> densityPercentage(int densityPercentage);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> rangePercentage(int rangePercentage);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> distributionType(ChartizateDistributionType distributionType);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> fontName(String fontName);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> fontSize(int fontSize);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> block(Character.UnicodeBlock block);

    public abstract ChartizateManagerBuilderAbstract<C, F, B> imageFullStream(InputStream imageFullStream) throws IOException;

    public abstract ChartizateManagerBuilderAbstract<C, F, B> destinationImagePath(String destinationImagePath);

    public abstract ChartizateManager<C, F, B> build() throws IOException;
}