package org.jesperancinha.chartizate.objects;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ChartizateCharacterImgImplTest {

    @Test
    public void testGetBg() throws Exception {
        final ChartizateCharacterImgImpl<Color> character = new ChartizateCharacterImgImpl<>(null, Color.BLACK, 0, ' ');
        assertThat(character.getBg()).isEqualTo(Color.BLACK);
    }

    @Test
    public void testGetFg() throws Exception {
        final ChartizateCharacterImgImpl<Color> character = new ChartizateCharacterImgImpl<>(Color.BLACK, null, 0, ' ');
        assertThat(character.getFg()).isEqualTo(Color.BLACK);
    }

    @Test
    public void testGetCharacter() throws Exception {
        final ChartizateCharacterImgImpl<Color> character = new ChartizateCharacterImgImpl<>(Color.BLACK, null, 0, ' ');
        assertThat(character.getCharacter()).isEqualTo(' ');
    }

    @Test
    public void testGetWidth() throws Exception {
        final ChartizateCharacterImgImpl<Color> character = new ChartizateCharacterImgImpl<>(null, null, 500, ' ');
        assertThat(character.getWidth()).isEqualTo(500);
    }
}
