package com.jesperancinha.chartizate;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import com.jesperancinha.chartizate.objects.ChartizateCharacterImg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.List;

/**
 * Manages the board to be rendered
 */
public class ChartizateManagerImpl extends ChartizateManagerCommon<Integer, Typeface, Bitmap> {


    public ChartizateManagerImpl(Integer backgroundColor, int densityPercentage, int rangePercentage, ChartizateDistributionType distributionType, String fontName, int fontSize, UnicodeBlock block, InputStream imageFullStream, String destinationImagePath) throws FileNotFoundException, IOException {
        super(backgroundColor, densityPercentage, rangePercentage, distributionType, fontName, fontSize, block, imageFullStream, destinationImagePath);
    }

    @Override
    public ChartizateImageManager<Integer, Typeface, Bitmap> createImageManager(InputStream inputStream) throws IOException {
        return new ChartizateImageManagerImpl(inputStream);
    }

    @Override
    public ChartizateEncodingManager createEncodingManager(UnicodeBlock unicodeBlock) {
        return new ChartizateEncodingManagerImpl(unicodeBlock, fontManager);
    }

    @Override
    public ChartizateFontManager<Typeface> createFontManager(String fontString, int fontSize) {
        return new ChartizateFontManagerImpl(fontString, fontSize);
    }

    @Override
    public void addFullRow(int row, List<ChartizateCharacterImg<Integer>> pencelizerRow) {
        chartizateBoard[row] = pencelizerRow.toArray(new ChartizateCharacterImg[0]);
    }
}
