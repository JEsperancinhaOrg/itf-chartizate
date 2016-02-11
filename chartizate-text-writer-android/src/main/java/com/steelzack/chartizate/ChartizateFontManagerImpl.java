package com.steelzack.chartizate;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author joao Manages the prescribed font
 */
public class ChartizateFontManagerImpl implements ChartizateFontManager<Typeface> {


    private final Paint mPaint;
    private Typeface font;
    private int fontSize;

    public ChartizateFontManagerImpl(String fontString, int fontSize) {
        this.fontSize = fontSize;
        this.font = Typeface.create(fontString, Typeface.NORMAL);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setTextSize(fontSize);
        mPaint.setTypeface(this.font);
    }

    private List<String> getAllUnicodeBlockStrings() {
        return Arrays.asList(new String[]{ //
                "Default", //
                "Monospace", //
                "Sans serif", //
                "Serif" //
        });
    }

    @Override
    public List<String> getAllUniCodeBlockStringsJava7() {
        return getAllUnicodeBlockStrings();
    }

    @Override
    public List<String> getAllUniCodeBlockStringsJava8() {
        return getAllUnicodeBlockStrings();
    }

    @Override
    public int getCharacterWidth(char c) {
        return (int) mPaint.measureText(new char[]{c}, 0, 1);
    }

    @Override
    public int getCharacterHeight(char c) {
        return fontSize;
    }

    @Override
    public Typeface getFont() {
        return font;
    }
}
