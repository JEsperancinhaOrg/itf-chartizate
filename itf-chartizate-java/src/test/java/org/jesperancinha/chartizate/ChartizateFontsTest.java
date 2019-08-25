package org.jesperancinha.chartizate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ChartizateFontsTest {

    /**
     * The number of available fonts will change per Java distribution. This is why we test that we do get a list and that it has at least one element
     */
    @Test
    public void getAllAvailableFonts() {
        List<String> allAvailableFonts = ChartizateFonts.getAllAvailableFonts();
        assertThat(allAvailableFonts).isNotNull();
        assertThat(allAvailableFonts).isNotEmpty();
        assertThat(allAvailableFonts).hasAtLeastOneElementOfType(String.class);
    }
}