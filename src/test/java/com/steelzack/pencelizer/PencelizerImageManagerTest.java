package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

/**
 * 
 * @author joao
 *
 */
public class PencelizerImageManagerTest {

	@Test
	public void testGetImageAverageColor_BlackGreen() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerBlackGreen.png");

		final PencelizerImageManager imageManager = new PencelizerImageManager(io);

		assertEquals(-13788928, imageManager.getImageAverageColor());
	}

	@Test
	public void testGetImageAverageColor_CyanBlack() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final PencelizerImageManager imageManager = new PencelizerImageManager(io);

		assertEquals(-16742778, imageManager.getImageAverageColor());
	}

	@Test
	public void testGetPartAverageColor_CyanBlack00() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");

		final PencelizerImageManager imageManager = new PencelizerImageManager(io);

		assertEquals(-16728129, imageManager.getPartAverageColor(0, 0, 10, 10));
	}
	
	@Test
	public void testGetPartAverageColor_CyanBlack10() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");
		
		final PencelizerImageManager imageManager = new PencelizerImageManager(io);
		
		assertEquals(-16759226, imageManager.getPartAverageColor(10, 0, 19, 10));
	}

}
