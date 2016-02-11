package com.steelzack.chartizate;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.List;

import com.steelzack.chartizate.ChartizateManagerCommon;
import com.steelzack.chartizate.objects.PencelizerCharacterImg;
import com.steelzack.pencelizer.distributions.PencelizerDistribution;
import com.steelzack.pencelizer.distributions.PencelizerDistributionType;
import com.steelzack.pencelizer.distributions.PencelizerLinearDistribution;

/**
 *
 * @author joao Manages the board to be rendered
 */
public class PencelizerManagerImpl extends ChartizateManagerCommon<Color, Font> {

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
	public PencelizerManagerImpl( //
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
		super(backgroundColor, //
				densityPercentage, //
				rangePercentage, //
				distributionType, //
				fontName, //
				fontSize, //
				block, //
				imageFullStream, //
				destinationImagePath //
		);
	}

	@Override
	protected PencelizerDistribution getDistribution(PencelizerDistributionType distributionType, int densityPercentage,
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
			List<PencelizerCharacterImg<Color>> pencelizerRow = new ArrayList<>();
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
				pencelizerRow.add(new PencelizerCharacterImg<Color>(new Color(averageColor), this.backgroundColor,
						width, character));
				currentImageIndexX += width;
			}
			addFullRow(rowIndex, pencelizerRow);
			currentImageIndexX = 0;
			rowIndex++;
		}
		imageManager.saveImage(pencelizerBoard, fontManager, this.desinationImagePath, imageWidth,
				imageManager.getImageHeight());
	}

	/**
	 * Sets row in position with a background color and a foreground color.
	 * Foreground color refers to the color of the character itself Background
	 * color refers to the background color in the cell of the character
	 * 
	 * @param pencelizerRow
	 */
	public void addFullRow(int row, List<PencelizerCharacterImg<Color>> pencelizerRow) {
		pencelizerBoard[row] = pencelizerRow.toArray(new PencelizerCharacterImg[0]);
	}

	@Override
	protected PencelizerImageManagerImpl createImageManager(final InputStream imageFullStream) throws IOException {
		return new PencelizerImageManagerImpl(imageFullStream);
	}

	@Override
	protected PencelizerEncodingManagerImpl createEncodingManager(final UnicodeBlock block) {
		return new PencelizerEncodingManagerImpl(block, fontManager);
	}

	@Override
	protected PencelizerFontManagerImpl createFontManager(final String fontName, final int fontSize) {
		return new PencelizerFontManagerImpl(fontName, fontSize);
	}

	public static void main(String[] args) {

	}
}
