package com.steelzack.chartizate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * @author joao
 */
public class ChartizateEncodingManagerImpl extends ChartizateEncodingManager<Typeface> {

    public ChartizateEncodingManagerImpl(Character.UnicodeBlock block, ChartizateFontManager<Typeface> fontManager) {
        super(block, fontManager);
    }

    @Override
    public int getCharacterFullness(Character character) {
        final int fontSize = fontManager.getFontSize();
        final Bitmap bitmap = Bitmap.createBitmap(fontSize, fontSize, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        final Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(fontSize);
        canvas.drawText(character.toString(), 0, 0, paint);
        return 0;
    }

    @Override
    public void init() {

    }

    @Override
    public Character[] getCharacters() {
        return new Character[0];
    }
}