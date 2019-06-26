package com.jesperancinha.chartizate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChartizateFontsTest {

    @Test
    void getAllAvailableFonts() {
        assertThat(ChartizateFonts.getAllAvailableFonts()).hasSize(251);
    }
}