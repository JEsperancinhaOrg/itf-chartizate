package org.jesperancinha.chartizate;

import java.util.Comparator;

public interface ChartizateEncodingManager<F> {

    int getCharacterFullness(Character character);

    Character[] getCharacters();

    int computeFullness(double fullNess, double total);

    Comparator<Character> getComparator();

    void init();
}
