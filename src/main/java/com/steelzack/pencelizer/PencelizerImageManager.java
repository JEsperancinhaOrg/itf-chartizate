package com.steelzack.pencelizer;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class PencelizerImageManager {

	private BufferedImage srcImage;

	public PencelizerImageManager(ImageInputStream io) throws IOException {
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

		return (long) (fullSum / (width * height));
	}
}
