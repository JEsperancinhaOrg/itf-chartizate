package com.steelzack.chartizate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;

import com.steelzack.chartizate.objects.PencelizerCharacterImg;
import com.steelzack.pencelizer.distributions.PencelizerDistribution;
import com.steelzack.pencelizer.distributions.PencelizerDistributionType;

public abstract class ChartizateManagerCommon<COLOR, FONT>{

	protected final COLOR backgroundColor;

	protected abstract PencelizerDistribution getDistribution(PencelizerDistributionType distributionType, int densityPercentage, int rangePercentage);

	protected final PencelizerDistribution distribution;
	protected final PencelizerCharacterImg<?>[][] pencelizerBoard;
	protected final PencelizerFontManager<FONT> fontManager;
	protected final PencelizerEncodingManager encodingManager;
	protected final PencelizerImageManager<FONT> imageManager;
	protected String desinationImagePath;

	public ChartizateManagerCommon( //
			final COLOR backgroundColor, //
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
		this.fontManager = createFontManager(fontName, fontSize);
		this.encodingManager = createEncodingManager(block);
		this.encodingManager.init();
		this.distribution = getDistribution(distributionType, densityPercentage, rangePercentage);
		this.imageManager = createImageManager(imageFullStream);
		this.desinationImagePath = destinationImagePath;
		final int imageHeight = imageManager.getImageHeight();
		this.pencelizerBoard = new PencelizerCharacterImg[imageHeight / fontSize][];
		
	}

	abstract PencelizerImageManager<FONT> createImageManager(final InputStream imageFullStream) throws IOException;
	
	abstract PencelizerEncodingManager createEncodingManager(final UnicodeBlock block);
	
	abstract PencelizerFontManager<FONT> createFontManager(final String fontName, final int fontSize) ;
}