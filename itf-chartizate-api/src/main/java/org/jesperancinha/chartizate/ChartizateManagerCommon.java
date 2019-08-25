package org.jesperancinha.chartizate;

import com.google.common.annotations.VisibleForTesting;
import org.jesperancinha.chartizate.distributions.ChartizateDistribution;
import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import org.jesperancinha.chartizate.distributions.ChartizateLinearDistribution;
import org.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public abstract class ChartizateManagerCommon<C, F, B> {

    private static Logger logger = LoggerFactory.getLogger(ChartizateManagerCommon.class);
    protected final ChartizateCharacterImg<?>[][] chartizateBoard;
    protected final ChartizateFontManager<F> fontManager;
    private final C backgroundC;
    private final ChartizateDistribution distribution;
    private final ChartizateEncodingManager<F> encodingManager;
    private final ChartizateImageManager<C, F, B> imageManager;
    private String destinationImagePath;

    public ChartizateManagerCommon(
        final C backgroundC,
        final int densityPercentage,
        final int rangePercentage,
        final ChartizateDistributionType distributionType,
        final String fontName,
        final int fontSize,
        final UnicodeBlock block,
        final InputStream imageFullStream,
        final String destinationImagePath
    ) throws IOException {
        this.backgroundC = backgroundC;
        this.fontManager = createFontManager(fontName, fontSize);
        this.encodingManager = createEncodingManager(block);
        this.encodingManager.init();
        this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
        this.imageManager = createImageManager(imageFullStream);
        this.destinationImagePath = destinationImagePath;
        final int imageHeight = imageManager.getImageHeight();
        this.chartizateBoard = new ChartizateCharacterImg[imageHeight / fontSize][];

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

    public void generateConvertedImage() throws IOException {
        B bufferedImage = createBufferedImage();
        if (ImageIO.write((BufferedImage) bufferedImage, "png", new File(this.destinationImagePath))) {
            logger.info(this.destinationImagePath + " is saved");
        }
    }

    public B generateConvertedImageStream() throws IOException {
        return this.createBufferedImage();
    }

    private B createBufferedImage() throws IOException {
        final int imageWidth = imageManager.getImageWidth();
        int currentImageIndexX = 0;
        int rowIndex = 0;
        while (rowIndex < chartizateBoard.length) {
            List<ChartizateCharacterImg<C>> chartizateRow = new ArrayList<>();
            while (currentImageIndexX < imageWidth) {
                final Character character = this.distribution.getCharacterFromArray();
                final int width = fontManager.getCharacterWidth(character);
                final int height = fontManager.getCharacterHeight(character);
                int currentImageIndexY = rowIndex * height;
                final C averageC = imageManager.getPartAverageColor(
                    currentImageIndexX,
                    currentImageIndexY,
                    currentImageIndexX + width,
                    currentImageIndexY + height
                );
                chartizateRow.add(new ChartizateCharacterImg<>(averageC, this.backgroundC,
                    width, character));
                currentImageIndexX += width;
            }
            addFullRow(rowIndex, chartizateRow);
            currentImageIndexX = 0;
            rowIndex++;
        }
        return imageManager.saveImage(chartizateBoard, fontManager, this.destinationImagePath, imageWidth,
            imageManager.getImageHeight());
    }

    @VisibleForTesting
    abstract ChartizateImageManager<C, F, B> createImageManager(final InputStream imageFullStream) throws IOException;

    @VisibleForTesting
    abstract ChartizateEncodingManager<F> createEncodingManager(final UnicodeBlock block);

    @VisibleForTesting
    abstract ChartizateFontManager<F> createFontManager(final String fontName, final int fontSize);

    @VisibleForTesting
    abstract void addFullRow(int row, List<ChartizateCharacterImg<C>> chartizateRow);
}