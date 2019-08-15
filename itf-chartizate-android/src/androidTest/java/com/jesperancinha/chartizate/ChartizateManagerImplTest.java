package com.jesperancinha.chartizate;

import android.app.Application;
import android.graphics.Color;
import android.test.ApplicationTestCase;
import com.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

/**
 * Created by joaofilipesabinoesperancinha on 11-02-16.
 */
public class ChartizateManagerImplTest extends ApplicationTestCase<Application> {
    public ChartizateManagerImplTest() {
        super(Application.class);
    }


    @Test
    public void testGenerateConvertedImageCyanBlack() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.pencelizercyanblack);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                50, //
                10, //
                ChartizateDistributionType.Linear, //
                "Arial", //
                5, //
                Character.UnicodeBlock.LATIN_EXTENDED_A, //
                imageFullStream, //
                new File(getContext().getCacheDir().getAbsolutePath(), "testCyanBlue.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageRealExample1() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample1);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.LATIN_EXTENDED_A, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testRealExample1.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageRealExample1Red() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample1);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.RED, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.LATIN_EXTENDED_A, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testRealExample1Red.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }


    @Test
    public void testGenerateConvertedImageLatinRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.LATIN_EXTENDED_A, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Latin.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageArabicRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.ARABIC, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Arabic.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageHebrewRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.HEBREW, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Hebrew.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSyriacRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.SYRIAC, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Syriac.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSamaritanRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.SAMARITAN, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Samaritan.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageMandaicRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.MANDAIC, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Mandaic.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageThaanaRealexample2() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample2);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                100, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.THAANA, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testrealexample2Thaana.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageRealExample1DensityFail1() throws Exception {
        final InputStream imageFullStream = getContext().getResources().openRawResource(R.raw.realexample1);

        assertNotNull(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl( //
                Color.BLACK, //
                1, //
                100, //
                ChartizateDistributionType.Linear, //
                "Times New Roman", //
                20, //
                Character.UnicodeBlock.LATIN_EXTENDED_A, //
                imageFullStream, //
                new File(getContext().getCacheDir(), "testRealExample1.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }
}