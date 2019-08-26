package org.jesperancinha.chartizate;

import junit.framework.TestCase;

/**
 * Created by joaofilipesabinoesperancinha on 11-02-16.
 */
public class ChartizateEncodingManagerImplTest extends TestCase {

    public void testGetCharacterFullness() {
        final ChartizateFontManagerImpl fontManager = new ChartizateFontManagerImpl("Default", 10);
        final ChartizateEncodingManagerImpl encodingManager = new ChartizateEncodingManagerImpl(Character.UnicodeBlock.LATIN_EXTENDED_A, fontManager);

        assertEquals(33, encodingManager.getCharacterFullness('.'));
        assertEquals(342, encodingManager.getCharacterFullness('O'));
        assertEquals(300, encodingManager.getCharacterFullness('0'));
    }

}