package com.jesperancinha.chartizate;

import com.jesperancinha.chartizate.distributions.ChartizateDistribution;
import com.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import com.jesperancinha.chartizate.distributions.ChartizateLinearDistribution;
import com.jesperancinha.chartizate.objects.ChartizateCharacterImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.List;

public abstract class ChartizateManagerCommon<COLOR, FONT> {

    private static Logger logger = LoggerFactory.getLogger(ChartizateManagerCommon.class);

    private final COLOR backgroundColor;
    private final ChartizateDistribution distribution;
    protected final ChartizateCharacterImg<?>[][] chartizateBoard;
    protected final ChartizateFontManager<FONT> fontManager;
    private final ChartizateEncodingManager<FONT> encodingManager;
    private final ChartizateImageManager<COLOR, FONT> imageManager;
    private String destinationImagePath;

    public ChartizateManagerCommon(
            final COLOR backgroundColor,
            final int densityPercentage,
            final int rangePercentage,
            final ChartizateDistributionType distributionType,
            final String fontName,
            final int fontSize,
            final UnicodeBlock block,
            final InputStream imageFullStream,
            final String destinationImagePath
    ) throws IOException {
        this.backgroundColor = backgroundColor;
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
                return null; //TODO: To be implemented
        }
        return null;
    }

    public void generateConvertedImage() throws IOException {
        BufferedImage bufferedImage = createBufferedImage();
        if (ImageIO.write(bufferedImage, "png", new File(this.destinationImagePath))) {
            logger.info(this.destinationImagePath + " is saved");
        }
    }

    public BufferedImage generateConvertedImageStream() throws IOException {
        return this.createBufferedImage();
    }

    private BufferedImage createBufferedImage() throws IOException {
        final int imageWidth = imageManager.getImageWidth();
        int currentImageIndexX = 0;
        int rowIndex = 0;
        while (rowIndex < chartizateBoard.length) {
            List<ChartizateCharacterImg<COLOR>> pencelizerRow = new ArrayList<>();
            while (currentImageIndexX < imageWidth) {
                final Character character = this.distribution.getCharacterFromArray();
                final int width = fontManager.getCharacterWidth(character);
                final int height = fontManager.getCharacterHeight(character);
                int currentImageIndexY = rowIndex * height;
                final COLOR averageColor = imageManager.getPartAverageColor(
                        currentImageIndexX,
                        currentImageIndexY,
                        currentImageIndexX + width,
                        currentImageIndexY + height
                );
                pencelizerRow.add(new ChartizateCharacterImg<>(averageColor, this.backgroundColor,
                        width, character));
                currentImageIndexX += width;
            }
            addFullRow(rowIndex, pencelizerRow);
            currentImageIndexX = 0;
            rowIndex++;
        }
        return imageManager.saveImage(chartizateBoard, fontManager, this.destinationImagePath, imageWidth,
                imageManager.getImageHeight());
    }

    abstract ChartizateImageManager<COLOR, FONT> createImageManager(final InputStream imageFullStream) throws IOException;

    abstract ChartizateEncodingManager<FONT> createEncodingManager(final UnicodeBlock block);

    abstract ChartizateFontManager<FONT> createFontManager(final String fontName, final int fontSize);

    abstract void addFullRow(int row, List<ChartizateCharacterImg<COLOR>> pencelizerRow);
}