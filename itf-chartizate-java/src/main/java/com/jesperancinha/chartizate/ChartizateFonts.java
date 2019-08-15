package com.jesperancinha.chartizate;

import com.google.common.annotations.VisibleForTesting;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class to manage all fonts
 */
@VisibleForTesting
class ChartizateFonts {

    /**
     * Returns a list of all awt available fonts
     *
     * @return List of all available Fonts
     */
    @VisibleForTesting
    static List<String> getAllAvailableFonts() {
        return Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    }
}
