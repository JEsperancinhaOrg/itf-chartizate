package com.jesperancinha.chartizate;

import com.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import com.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.List;

public class ChartizateManagerImpl extends ChartizateManagerCommon<Color, Font> {

    /**
     * Creates Pencelizer manager by defining how many lines and columns is the
     * array going to have
     *
     * @param backgroundColor
     * @param densityPercentage
     * @param rangePercentage
     * @param distributionType
     * @param fontName
     * @param fontSize
     * @param block
     * @param imageFullStream
     * @param destinationImagePath
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ChartizateManagerImpl(
            final Color backgroundColor,
            final int densityPercentage,
            final int rangePercentage,
            final ChartizateDistributionType distributionType,
            final String fontName,
            final int fontSize,
            final UnicodeBlock block,
            final InputStream imageFullStream,
            final String destinationImagePath
    ) throws FileNotFoundException, IOException {
        super(backgroundColor,
                densityPercentage,
                rangePercentage,
                distributionType,
                fontName,
                fontSize,
                block,
                imageFullStream,
                destinationImagePath
        );
    }
    /**
     * Creates Pencelizer manager by defining how many lines and columns is the
     * array going to have
     *
     * @param backgroundColor
     * @param densityPercentage
     * @param rangePercentage
     * @param distributionType
     * @param fontName
     * @param fontSize
     * @param block
     * @param imageFullStream
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ChartizateManagerImpl(
            final Color backgroundColor,
            final int densityPercentage,
            final int rangePercentage,
            final ChartizateDistributionType distributionType,
            final String fontName,
            final int fontSize,
            final UnicodeBlock block,
            final InputStream imageFullStream
    ) throws FileNotFoundException, IOException {
        super(backgroundColor,
                densityPercentage,
                rangePercentage,
                distributionType,
                fontName,
                fontSize,
                block,
                imageFullStream,
                null
        );
    }

    /**
     * Sets row in position with a background color and a foreground color.
     * Foreground color refers to the color of the character itself Background
     * color refers to the background color in the cell of the character
     *
     * @param chartizateCharacterImgs
     */
    @Override
    public void addFullRow(int row, List<ChartizateCharacterImg<Color>> chartizateCharacterImgs) {
        chartizateBoard[row] = chartizateCharacterImgs.toArray(new ChartizateCharacterImg[0]);
    }

    @Override
    protected ChartizateImageManagerImpl createImageManager(
            final InputStream imageFullStream) throws IOException {
        return new ChartizateImageManagerImpl(imageFullStream);
    }

    @Override
    protected ChartizateEncodingManagerImpl createEncodingManager(final UnicodeBlock block) {
        return new ChartizateEncodingManagerImpl(block, fontManager);
    }

    @Override
    protected ChartizateFontManagerImpl createFontManager(final String fontName, final int fontSize) {
        return new ChartizateFontManagerImpl(fontName, fontSize);
    }

}
