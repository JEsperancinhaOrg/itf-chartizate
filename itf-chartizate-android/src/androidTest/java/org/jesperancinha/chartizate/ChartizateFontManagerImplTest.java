package org.jesperancinha.chartizate;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ChartizateFontManagerImplTest extends TestCase {

    public void testGetCharacterWidth() {
        final ChartizateFontManagerImpl fontManager = new ChartizateFontManagerImpl("SERIF", 10);
        Assert.assertEquals(3, fontManager.getCharacterWidth(':'));
        Assert.assertEquals(7, fontManager.getCharacterWidth('A'));
    }
}