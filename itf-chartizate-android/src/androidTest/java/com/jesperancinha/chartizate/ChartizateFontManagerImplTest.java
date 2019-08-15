package com.jesperancinha.chartizate;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ChartizateFontManagerImplTest extends TestCase {

    public void testGetCharacterWidth() throws Exception {
        final ChartizateFontManagerImpl fontManager = new ChartizateFontManagerImpl("SERIF", 10);
        Assert.assertEquals(3, fontManager.getCharacterWidth(':'));
        Assert.assertEquals(7, fontManager.getCharacterWidth('A'));
    }

    public void testGetCharacterHeight() throws Exception {

    }

    public void testGetFont() throws Exception {

    }
}