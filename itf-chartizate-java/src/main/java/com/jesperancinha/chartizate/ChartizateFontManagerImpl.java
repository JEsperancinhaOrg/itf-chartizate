package com.jesperancinha.chartizate;

import java.awt.*;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChartizateFontManagerImpl extends ChartizateFontManager<Font> {

    private Font font;

    private FontMetrics fontMetrics;

    ChartizateFontManagerImpl(String fontName, int fontSize) {
        this.font = new Font(fontName, Font.PLAIN, fontSize);
        Canvas c = new Canvas();
        this.fontMetrics = c.getFontMetrics(font);
    }

    @Override
    public int getCharacterWidth(char c) {
        return fontMetrics.stringWidth(new String(new char[]{c}));
    }

    @Override
    public int getCharacterHeight(char c) {
        return font.getSize();
    }

    @Override
    public Font getFont() {
        return font;
    }

    static List<String> getAllFontTypes() {
        return Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    }

    @Override
    public int getFontSize() {
        return font.getSize();
    }
}
