package com.steelzack.pencelizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
 * @author joao
 *
 */
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
		final int width = srcImage.getWidth() - 1;
		final int height = srcImage.getHeight() - 1;
		return getPartAverageColor(0, 0, width, height);
	}

	public int getPartAverageColor(final int x0, final int y0, final int xn, final int yn) {
		double alpha = 0;
		double red = 0;
		double green = 0;
		double blue = 0;
		for (int j = x0; j <= xn; j++) {
			for (int k = y0; k <= yn; k++) {
				int rgbPixel = srcImage.getRGB(j, k);
				alpha += (rgbPixel >> 24) & 0xff;
				red += (rgbPixel >> 16) & 0xff;
				green += (rgbPixel >> 8) & 0xff;
				blue += (rgbPixel) & 0xff;
			}
		}

		int commonDenominator = (xn - x0 + 1) * (yn - y0 + 1);
		int mediumApha = (int) (alpha / commonDenominator);
		int mediumRed = (int) (red / commonDenominator);
		int mediumBlue = (int) (blue / commonDenominator);
		int mediumGreen = (int) (green / commonDenominator);

		int fullSum = new Color(mediumRed, mediumGreen, mediumBlue, mediumApha).getRGB();
		return fullSum;
	}

	public void saveImage(PencelizerCharacterImg[][] pencelizerBoard, Font font, String outputFile) throws IOException {
		PencelizerCharacterImg character = pencelizerBoard[0][0];
		BufferedImage bImg = new BufferedImage(character.getWidth(), font.getSize(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bImg.createGraphics();
		g2d.setFont(font);
		g2d.setColor(character.getFg());
		g2d.drawString(character.toString(), 0, font.getSize());
		g2d.dispose();
		if (ImageIO.write(bImg, "png", new File(outputFile))) {
			System.out.println(outputFile + "is saved");
		}
	}
}
