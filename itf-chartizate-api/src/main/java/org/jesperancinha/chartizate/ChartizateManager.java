package org.jesperancinha.chartizate;

import java.io.IOException;

public interface ChartizateManager<C, F, B> {

    B generateConvertedImage() throws IOException;

    B generateConvertedImageStream() throws IOException;

    B createBufferedImage() throws IOException;
}
