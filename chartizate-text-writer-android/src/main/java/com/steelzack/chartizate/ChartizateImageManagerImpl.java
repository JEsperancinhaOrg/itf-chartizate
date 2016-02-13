package com.steelzack.chartizate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;

import com.steelzack.chartizate.objects.ChartizateCharacterImg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author joao
 */
public class ChartizateImageManagerImpl extends ChartizateImageManager<Integer,Typeface> {

    private final InputStream inputStream;
    private Bitmap bitmap;

    public ChartizateImageManagerImpl(final InputStream inputStream) {
        this.inputStream = inputStream;
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception e) {
            bitmap = null;
            e.printStackTrace();
        }
    }

    @Override
    public int getImageWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getImageHeight() {
        return bitmap.getHeight();
    }


    @Override
    public Integer getPartAverageColor(int i, int i1, int i2, int i3) {
        return null;
    }

    @Override
    int getImagePixelRGB(int i, int i1) {
        return 0;
    }

    @Override
    Integer createColor(int alpha, int red, int green, int blue) {
        return  Color.argb(alpha, red, green, blue);
    }

    @Override
    public void saveImage(ChartizateCharacterImg<?>[][] chartizateCharacterImgs, ChartizateFontManager<Typeface> chartizateFontManager, String s, int i, int i1) throws IOException {

    }
}
