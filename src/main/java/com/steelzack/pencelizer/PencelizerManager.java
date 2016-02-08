package com.steelzack.pencelizer;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.List;

import com.steelzack.pencelizer.distributions.PencelizerDistribution;
import com.steelzack.pencelizer.distributions.PencelizerDistributionType;
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
			final PencelizerDistributionType distributionType, //
			final String fontName, //
			final int fontSize, //
			final UnicodeBlock block, //
			final InputStream imageFullStream, //
			final String destinationImagePath //
	) throws FileNotFoundException, IOException {
		this.backgroundColor = backgroundColor;
		this.fontManager = new PencelizerFontManager(fontName, fontSize);
		this.encodingManager = new PencelizerEncodingManager(block, fontManager);
		this.encodingManager.init();
		this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
		this.imageManager = new PencelizerImageManager(imageFullStream);
		this.desinationImagePath = destinationImagePath;
		final int imageHeight = imageManager.getImageHeight();
		this.pencelizerBoard = new PencelizerCharacterImg[imageHeight / fontSize][];
	}

	private PencelizerDistribution getDistribution(PencelizerDistributionType distributionType, int densityPercentage,
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
		final int imageWidth = imageManager.getImageWidth();
		int currentImageIndexX = 0;
		int rowIndex = 0;
		while (rowIndex < pencelizerBoard.length) {
			List<PencelizerCharacterImg> pencelizerRow = new ArrayList<>();
			while (currentImageIndexX < imageWidth) {
				final Character character = this.distribution.getCharacterFromArray();
				final int width = fontManager.getCharacterWidth(character.charValue());
				final int height = fontManager.getCharacterHeight(character.charValue());
				int currentImageIndexY = rowIndex * height;
				final int averageColor = imageManager.getPartAverageColor( //
						currentImageIndexX, //
						currentImageIndexY, //
						currentImageIndexX + width, //
						currentImageIndexY + height //
				);
				pencelizerRow.add(
						new PencelizerCharacterImg(new Color(averageColor), this.backgroundColor, width, character));
				currentImageIndexX += width;
			}
			addFullRow(rowIndex, pencelizerRow);
			currentImageIndexX=0;
			rowIndex++;
		}
		imageManager.saveImage(pencelizerBoard, fontManager.getFont(), this.desinationImagePath, imageWidth, imageManager.getImageHeight());
	}

	/**
	 * Sets row in position with a background color and a foreground color.
	 * Foreground color refers to the color of the character itself Background
	 * color refers to the background color in the cell of the character
	 * 
	 * @param pencelizerRow
	 */
	public void addFullRow(int row, List<PencelizerCharacterImg> pencelizerRow) {
		pencelizerBoard[row] = pencelizerRow.toArray(new PencelizerCharacterImg[0]);
	}

	public static void main(String[] args) {

	}
}
