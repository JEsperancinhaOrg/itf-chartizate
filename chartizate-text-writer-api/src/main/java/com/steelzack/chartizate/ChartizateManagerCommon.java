package com.steelzack.chartizate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;
import java.util.List;

import com.steelzack.chartizate.distributions.ChartizateDistribution;
import com.steelzack.chartizate.distributions.ChartizateDistributionType;
import com.steelzack.chartizate.distributions.PencelizerLinearDistribution;
import com.steelzack.chartizate.objects.ChartizateCharacterImg;

public abstract class ChartizateManagerCommon<COLOR, FONT> {

	protected final COLOR backgroundColor;
	protected final ChartizateDistribution distribution;
	protected final ChartizateCharacterImg<?>[][] pencelizerBoard;
	protected final ChartizateFontManager<FONT> fontManager;
	protected final ChartizateEncodingManager encodingManager;
	protected final ChartizateImageManager<FONT> imageManager;
	protected String desinationImagePath;

	public ChartizateManagerCommon( //
			final COLOR backgroundColor, //
			final int densityPercentage, //
			final int rangePercentage, //
			final ChartizateDistributionType distributionType, //
			final String fontName, //
			final int fontSize, //
			final UnicodeBlock block, //
			final InputStream imageFullStream, //
			final String destinationImagePath //
	) throws FileNotFoundException, IOException {
		this.backgroundColor = backgroundColor;
		this.fontManager = createFontManager(fontName, fontSize);
		this.encodingManager = createEncodingManager(block);
		this.encodingManager.init();
		this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
		this.imageManager = createImageManager(imageFullStream);
		this.desinationImagePath = destinationImagePath;
		final int imageHeight = imageManager.getImageHeight();
		this.pencelizerBoard = new ChartizateCharacterImg[imageHeight / fontSize][];

	}

	protected ChartizateDistribution getDistribution( //
			ChartizateDistributionType distributionType, //
			int densityPercentage, //
			int rangePercentage //
	) {
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

	abstract ChartizateImageManager<FONT> createImageManager(final InputStream imageFullStream) throws IOException;

	abstract ChartizateEncodingManager createEncodingManager(final UnicodeBlock block);

	abstract ChartizateFontManager<FONT> createFontManager(final String fontName, final int fontSize);

	abstract void addFullRow(int row, List<ChartizateCharacterImg<COLOR>> pencelizerRow);
}