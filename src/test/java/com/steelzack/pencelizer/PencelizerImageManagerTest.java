package com.steelzack.pencelizer;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

public class PencelizerImageManagerTest {

	@Test
	public void testGetImageAverageColor_BlackGreen() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerBlackGreen.png");
		
		final PencelizerImageManager imageManager = new PencelizerImageManager(io);
		
		assertEquals(13755993, imageManager.getImageAverageColor());
	}

	
	@Test
	public void testGetImageAverageColor_CyanBlack() throws Exception {
		InputStream io = getClass().getResourceAsStream("pencelizerCyanBlack.png");
		
		final PencelizerImageManager imageManager = new PencelizerImageManager(io);
		
		assertEquals(16742713, imageManager.getImageAverageColor());
	}
	
	@Test
	public void testPencelizerImageManager() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
