package com.steelzack.pencelizer;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;

import com.steelzack.pencelizer.distributions.PencelizerDistribution;
import com.steelzack.pencelizer.distributions.PencelizerDistributionTypes;
import com.steelzack.pencelizer.distributions.PencelizerLinearDistribution;

/**
 *
 * @author joao Manages the whole board to be rendered
 */
public class PencelizerManager {

	private final Color backgroundColor;

	private final PencelizerDistribution distribution;

	private final PencelizerCharacterImg[][] pencelizerBoard;

	private final PencelizerFontManager fontManager;

	private final PencelizerEncodingManager encodingManager;

	private final PencelizerImageManager imageManager;

	private String desinationImagePath;

	/**
	 * Creates Pencelizer manager by defining how many lines and columns is the
	 * array going to have
	 * 
	 * @param nLines
	 * @param backgroundColor
	 * @param densityPercentage
	 * @param rangePercentage
	 * @param distributionType
	 * @param fontName
	 * @param fontSize
	 * @param block
	 * @param imageFullPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public PencelizerManager(int nLines, //
			final Color backgroundColor, //
			final int densityPercentage, //
			final int rangePercentage, //
			final PencelizerDistributionTypes distributionType, //
			final String fontName, //
			final int fontSize, //
			final UnicodeBlock block, //
			final InputStream imageFullStream, //
			final String destinationImagePath //
	) throws FileNotFoundException, IOException {
		this.pencelizerBoard = new PencelizerCharacterImg[nLines][];
		this.backgroundColor = backgroundColor;
		this.fontManager = new PencelizerFontManager(fontName, fontSize);
		this.encodingManager = new PencelizerEncodingManager(block, fontManager);
		this.encodingManager.init();
		this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
		this.imageManager = new PencelizerImageManager(imageFullStream);
		this.desinationImagePath = destinationImagePath;
	}

	private PencelizerDistribution getDistribution(PencelizerDistributionTypes distributionType, int densityPercentage,
			int rangePercentage) {
		switch (distributionType) {
		case Gaussian:
			return null; // TODO: To be implemented
		case Linear:
			return new PencelizerLinearDistribution( //
					this.encodingManager.getCharacters(), // 
					densityPercentage, //
					rangePercentage //
					);
		case Poisson:
			return null; // TODO: To be implemented
		default:
			break;
		}
		return null;
	}

	public void generateConvertedImage() throws IOException {
		final Character character = this.distribution.getCharacterFromArray();
		final int width = fontManager.getCharacterWidth(character.charValue());
		final int height = fontManager.getCharacterHeight(character.charValue());
		final int averageColor = imageManager.getPartAverageColor(0, 0, width, height);
		addRow(1);
		setPencelizerCharacter(0, 0, width, new Color(averageColor), this.backgroundColor, character);

		imageManager.saveImage(pencelizerBoard, fontManager.getFont(), this.desinationImagePath);
	}

	/**
	 * Adds a row to the row set with the amount of columns discovered It used
	 * to draw and ship image
	 * 
	 * @param nColumns
	 *            Number of columns necessary
	 */
	public void addRow(int nColumns) {
		pencelizerBoard[pencelizerBoard.length - 1] = new PencelizerCharacterImg[nColumns];
	}

	/**
	 * Sets character in position with a background color and a foreground
	 * color. Foreground color refers to the color of the character itself
	 * Background color refers to the background color in the cell of the
	 * character
	 * 
	 * @param l
	 *            Number of lines
	 * @param c
	 *            Number of columns
	 * @param fg
	 *            Foreground color
	 * @param bg
	 *            Background color
	 * @param character
	 *            The chosen character
	 */
	public void setPencelizerCharacter(int l, int c, int width, Color fg, Color bg, char character) {

		pencelizerBoard[l][c] = new PencelizerCharacterImg(fg, bg, width, character);
	}

	public static void main(String[] args) {

	}
}
