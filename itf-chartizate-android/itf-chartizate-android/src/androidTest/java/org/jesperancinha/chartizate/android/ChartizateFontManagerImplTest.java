package org.jesperancinha.chartizate.android;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.jesperancinha.chartizate.ChartizateFontManager;
import org.jesperancinha.chartizate.ChartizateFontManagerImpl;

public class ChartizateFontManagerImplTest extends TestCase {

    public void testGetCharacterWidth() {
        final ChartizateFontManager fontManager = new ChartizateFontManagerImpl("SERIF", 10);
        Assert.assertEquals(2, fontManager.getCharacterWidth(':'));
        Assert.assertEquals(7, fontManager.getCharacterWidth('A'));
    }
}