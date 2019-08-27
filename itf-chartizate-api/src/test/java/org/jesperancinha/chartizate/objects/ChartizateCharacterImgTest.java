package org.jesperancinha.chartizate.objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ChartizateCharacterImgTest {

    @Test
    public void testGetBg() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(null, Color.BLACK, 0, ' ');
        assertThat(character.getBg()).isEqualTo(Color.BLACK);
    }

    @Test
    public void testGetFg() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(Color.BLACK, null, 0, ' ');
        assertThat(character.getFg()).isEqualTo(Color.BLACK);
    }

    @Test
    public void testGetCharacter() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(Color.BLACK, null, 0, ' ');
        assertThat(character.getCharacter()).isEqualTo(' ');
    }

    @Test
    public void testGetWidth() throws Exception {
        final ChartizateCharacterImg<Color> character = new ChartizateCharacterImg<>(null, null, 500, ' ');
        assertThat(character.getWidth()).isEqualTo(500);
    }
}
