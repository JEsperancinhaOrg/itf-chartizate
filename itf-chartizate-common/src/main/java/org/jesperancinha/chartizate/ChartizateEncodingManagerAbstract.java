package org.jesperancinha.chartizate;

import java.lang.Character.UnicodeBlock;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public abstract class ChartizateEncodingManagerAbstract<F> implements ChartizateEncodingManager<F> {
    protected final ChartizateFontManager<F> fontManager;
    private final UnicodeBlock block;
    protected Character[] characters;
    protected int maximumHeight = 0;
    private Set<Character> orderedCharacters = new TreeSet<>(getComparator());

    ChartizateEncodingManagerAbstract(UnicodeBlock block, ChartizateFontManager<F> fontManager) {
        super();
        this.block = block;
        this.fontManager = fontManager;
    }

    public abstract int getCharacterFullness(Character character);

    public abstract Character[] getCharacters();

    public int computeFullness(double fullNess, double total) {
        return (int) (fullNess / total * 1000);
    }

    public Comparator<Character> getComparator() {
        return (o1, o2) -> {
            double fullNess1 = getCharacterFullness(o1);
            double fullNess2 = getCharacterFullness(o2);
            int comparisonResult = ((fullNess1 < fullNess2) ? -1 : 0);
            if (comparisonResult == 0) {
                comparisonResult = o1.compareTo(o2);
            }

            return comparisonResult;
        };
    }

    public void init() {
        for (int codePoint = Character.MIN_CODE_POINT; codePoint <= Character.MAX_CODE_POINT; codePoint++) {
            if (block == UnicodeBlock.of(codePoint)) {
                orderedCharacters.add(((char) codePoint));

                int height = fontManager.getCharacterHeight((char) codePoint);
                if (height > maximumHeight) {
                    maximumHeight = height;
                }
            }
        }
        characters = orderedCharacters.toArray(new Character[0]);
    }
}
