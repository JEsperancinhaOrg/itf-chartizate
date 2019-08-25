package org.jesperancinha.chartizate.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.awt.*;

public class ChartizateCharacterImgTest {

    @Test
    public void testGetBg() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(null, Color.BLACK, 0, ' ');
        assertEquals(Color.BLACK, character.getBg());
    }

    @Test
    public void testGetFg() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(Color.BLACK, null, 0, ' ');
        assertEquals(Color.BLACK, character.getFg());
    }

    @Test
    public void testGetCharacter() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(Color.BLACK, null, 0, ' ');
        assertEquals(' ', character.getCharacter());
    }

    @Test
    public void testGetWidth() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(null, null, 500, ' ');
        assertEquals(500, character.getWidth());
    }
}
