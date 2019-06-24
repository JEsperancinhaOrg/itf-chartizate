package com.jesperancinha.chartizate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.jesperancinha.chartizate.ChartizateFontManager;
import com.jesperancinha.chartizate.ChartizateImageManager;
import com.jesperancinha.chartizate.objects.ChartizateCharacterImg;

public class ChartizateImageManagerImpl extends ChartizateImageManager<Color, Font> {

	private BufferedImage srcImage;

	ChartizateImageManagerImpl() {
		// For testing purposes only
	}

	ChartizateImageManagerImpl(InputStream io) throws IOException {
		this.srcImage = ImageIO.read(io);
	}

	@Override
	public int getImageWidth() {
		return this.srcImage.getWidth();
	}

	@Override
	public int getImageHeight() {
		return this.srcImage.getHeight();
	}

	@Override
	public void saveImage(ChartizateCharacterImg<?>[][] pencelizerBoard, ChartizateFontManager<Font> fontManager,
			String outputFile, int outputWidth, int outputHeight) throws IOException {
		final BufferedImage bImg = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB);
		final Graphics2D g2d = bImg.createGraphics();
		final Font font = fontManager.getFont();
		g2d.setFont(font);

		int currentWidth = 0;
		for (int i = 0; i < pencelizerBoard.length; i++) {
			int rowLength = pencelizerBoard[i].length;
			for (int j = 0; j < rowLength; j++) {
				final ChartizateCharacterImg<?> character = pencelizerBoard[i][j];
				g2d.setColor((Color) character.getFg());
				g2d.drawString(character.toString(), currentWidth, font.getSize() * (i + 1));
				currentWidth += pencelizerBoard[i][j].getWidth();
			}
			currentWidth = 0;
		}
		g2d.dispose();

		if (ImageIO.write(bImg, "png", new File(outputFile))) {
			System.out.println(outputFile + " is saved");
		}
	}
	
	@Override
	public int getImagePixelRGB(int j, int k) {
		return srcImage.getRGB(j, k);
	}
	
	@Override
	public Color createColor(int mediumApha, int mediumRed, int mediumGreen, int mediumBlue) {
		return new Color(mediumRed, mediumGreen, mediumBlue, mediumApha);
	}
	
	@Override
	protected int getBlue(int rgbPixel) {
		return (rgbPixel) & 0xff;
	}

	@Override
	protected int getGreen(int rgbPixel) {
		return (rgbPixel >> 8) & 0xff;
	}

	@Override
	protected int getRed(int rgbPixel) {
		return (rgbPixel >> 16) & 0xff;
	}

	@Override
	protected int getAlpha(int rgbPixel) {
		return (rgbPixel >> 24) & 0xff;
	}
}
