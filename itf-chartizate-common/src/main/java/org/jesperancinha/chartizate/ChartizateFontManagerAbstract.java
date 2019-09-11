package org.jesperancinha.chartizate;

public abstract class ChartizateFontManagerAbstract<T> implements ChartizateFontManager<T> {

    /**
     * Gets the width of a particular character
     *
     * @param c Character
     * @return Width of character
     */
    public abstract int getCharacterWidth(char c);

    /**
     * Gets full height of a particular character
     *
     * @param c Character
     * @return Width of character
     */
    public abstract int getCharacterHeight(char c);

    public abstract T getFont();

    public abstract int getFontSize();
}