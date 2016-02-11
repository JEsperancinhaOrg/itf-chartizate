package com.steelzack.chartizate;

/**
 * @author joao
 */
public class ChartizateEncodingManagerImpl implements ChartizateEncodingManager {

    private final Character.UnicodeBlock unicodeBlock;

    public ChartizateEncodingManagerImpl(Character.UnicodeBlock unicodeBlock) {
        this.unicodeBlock = unicodeBlock;
    }

    @Override
    public int getCharacterFullness(Character character) {
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