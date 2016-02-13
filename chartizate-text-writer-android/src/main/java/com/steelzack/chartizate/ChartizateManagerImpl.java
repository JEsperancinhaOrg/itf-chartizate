package com.steelzack.chartizate;

import android.graphics.Typeface;

import com.steelzack.chartizate.distributions.ChartizateDistributionType;
import com.steelzack.chartizate.objects.ChartizateCharacterImg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.List;

/**
 * @author joao Manages the board to be rendered
 */
public class ChartizateManagerImpl extends ChartizateManagerCommon<Integer, Typeface> {


    public ChartizateManagerImpl(Integer backgroundColor, int densityPercentage, int rangePercentage, ChartizateDistributionType distributionType, String fontName, int fontSize, UnicodeBlock block, InputStream imageFullStream, String destinationImagePath) throws FileNotFoundException, IOException {
        super(backgroundColor, densityPercentage, rangePercentage, distributionType, fontName, fontSize, block, imageFullStream, destinationImagePath);
    }

    @Override
    ChartizateImageManager<Integer, Typeface> createImageManager(InputStream inputStream) throws IOException {
        return new ChartizateImageManagerImpl(inputStream);
    }

    @Override
    ChartizateEncodingManager createEncodingManager(UnicodeBlock unicodeBlock) {
        return new ChartizateEncodingManagerImpl(unicodeBlock, fontManager);
    }

    @Override
    ChartizateFontManager<Typeface> createFontManager(String fontString, int fontSize) {
        return new ChartizateFontManagerImpl(fontString, fontSize);
    }

    @Override
    void addFullRow(int row, List<ChartizateCharacterImg<Integer>> pencelizerRow) {
            pencelizerBoard[row] = pencelizerRow.toArray(new ChartizateCharacterImg[0]);
    }
}
