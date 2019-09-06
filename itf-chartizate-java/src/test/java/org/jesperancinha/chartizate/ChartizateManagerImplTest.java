package org.jesperancinha.chartizate;

import org.junit.Test;

import java.awt.*;
import java.io.InputStream;
import java.lang.Character.UnicodeBlock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.chartizate.distributions.ChartizateDistributionType.Linear;


public class ChartizateManagerImplTest {

    @Test
    public void testGenerateConvertedImageStreamCustomColor() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("pencelizerCyanBlack.png");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                new Color(15280682),
                50,
                10,
                Linear,
                "Arial",
                5,
                UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                "/tmp/testCyanCustom.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageStreamCyanBlack() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("pencelizerCyanBlack.png");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLUE,
                50,
                10,
                Linear,
                "Arial",
                5,
                UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                "/tmp/testCyanBlue.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageCyanBlack() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("pencelizerCyanBlack.png");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                50,
                10,
                Linear,
                "Arial",
                5,
                UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                "/tmp/testCyanBlue.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageLatinRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");

        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                "/tmp/testRealExample2Latin.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageArabicRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.ARABIC,
                imageFullStream,
                "/tmp/testRealExample2Arabic.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageHebrewRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.HEBREW,
                imageFullStream,
                "/tmp/testRealExample2Hebrew.png"
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSyriacRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.SYRIAC,
                imageFullStream,
                "/tmp/testRealExample2Syriac.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSamaritanRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.SAMARITAN,
                imageFullStream,
                "/tmp/testRealExample2Samaritan.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageMandaicRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.MANDAIC,
                imageFullStream,
                "/tmp/testRealExample2Mandaic.png"
        );

        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageThaanaRealExample2() throws Exception {
        final InputStream imageFullStream = getClass().getResourceAsStream("RealExample2.jpg");
        assertThat(imageFullStream).isNotNull();
        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.RED,
                100,
                100,
                Linear,
                "Times New Roman",
                20,
                UnicodeBlock.THAANA,
                imageFullStream,
                "/tmp/testRealExample2Thaana.png"
        );

        manager.generateConvertedImage();
    }
}
