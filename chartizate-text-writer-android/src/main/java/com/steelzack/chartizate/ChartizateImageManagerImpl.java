package com.steelzack.chartizate;

import android.graphics.Typeface;

import com.steelzack.chartizate.objects.ChartizateCharacterImg;

import java.io.IOException;

/**
 * @author joao
 */
public class ChartizateImageManagerImpl implements ChartizateImageManager<Typeface> {


    @Override
    public int getImageWidth() {
        return 0;
    }

    @Override
    public int getImageHeight() {
        return 0;
    }

    @Override
    public long getImageAverageColor() {
        return 0;
    }

    @Override
    public int getPartAverageColor(int i, int i1, int i2, int i3) {
        return 0;
    }

    @Override
    public void saveImage(ChartizateCharacterImg<?>[][] chartizateCharacterImgs, ChartizateFontManager<Typeface> chartizateFontManager, String s, int i, int i1) throws IOException {

    }
}
