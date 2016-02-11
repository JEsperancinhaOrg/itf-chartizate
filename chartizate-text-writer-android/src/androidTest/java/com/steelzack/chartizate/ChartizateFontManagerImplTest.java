package com.steelzack.chartizate;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by joaofilipesabinoesperancinha on 11-02-16.
 */
public class ChartizateFontManagerImplTest extends TestCase {

    public void testGetAllUniCodeBlockStringsJava7() throws Exception {

    }

    public void testGetAllUniCodeBlockStringsJava8() throws Exception {

    }

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