package com.steelzack.pencelizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Character.UnicodeBlock;

import org.fusesource.jansi.Ansi.Color;

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

	private final PencelizerCharacter[][] pencelizerBoard;

	private final PencelizerFontManager fontManager;

	private final PencelizerEncodingManager encodingManager;

	private final PencelizerImageManager imageManager;

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
			final String imageFullPath //
	) throws FileNotFoundException, IOException {
		this.pencelizerBoard = new PencelizerCharacter[nLines][];
		this.backgroundColor = backgroundColor;
		this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
		this.fontManager = new PencelizerFontManager(fontName, fontSize);
		this.encodingManager = new PencelizerEncodingManager(block, fontManager);
		encodingManager.init();
		this.imageManager = new PencelizerImageManager(new FileInputStream(new File(imageFullPath)));

	}

	private PencelizerDistribution getDistribution(PencelizerDistributionTypes distributionType, int densityPercentage,
			int rangePercentage) {
		switch (distributionType) {
		case Gaussian:
			return null; // TODO: To be implemented
		case Linear:
			return new PencelizerLinearDistribution(this.encodingManager.getCharacters(), densityPercentage,
					rangePercentage);
		case Poisson:
			return null; // TODO: To be implemented
		default:
			break;
		}
		return null;
	}

	public void generateConvertedImage() {

	}

	/**
	 * Adds a row to the row set with the amount of columns discovered It used
	 * to draw and ship image
	 * 
	 * @param nColumns
	 *            Number of columns necessary
	 */
	public void addRow(int nColumns) {
		pencelizerBoard[pencelizerBoard.length - 1] = new PencelizerCharacter[nColumns];
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
	public void setPencelizerCharacter(int l, int c, Color fg, Color bg, char character) {

		pencelizerBoard[l][c] = new PencelizerCharacter(fg, bg, character);
	}
}
