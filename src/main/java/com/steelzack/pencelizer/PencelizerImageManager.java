package com.steelzack.pencelizer;

import static java.lang.Math.abs;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PencelizerImageManager {

	private BufferedImage srcImage;

	public PencelizerImageManager(InputStream io) throws IOException {
		try {
			BufferedImage image = ImageIO.read(io);
			this.srcImage = image;
		} catch (IOException ex) {
			throw ex;
		}
	}

	public long getImageAverageColor() {
		final int width = srcImage.getWidth();
		final int height = srcImage.getHeight();

		double fullSum = 0d;

		for (int j = 0; j < width; j++) {
			for (int k = 0; k < height; k++) {
				fullSum += srcImage.getRGB(j, k);
			}
		}

		return abs((long) (fullSum / (width * height)));
	}
}
