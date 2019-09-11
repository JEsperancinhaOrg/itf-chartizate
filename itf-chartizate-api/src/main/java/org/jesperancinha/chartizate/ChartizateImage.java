package org.jesperancinha.chartizate;

import org.jesperancinha.chartizate.objects.ColorHelper;

public interface ChartizateImage<C> {
    int getImageWidth();

    int getImageHeight();

    int getImagePixelRGB(int j, int k);

    C createColor(ColorHelper colorHelper);
}
