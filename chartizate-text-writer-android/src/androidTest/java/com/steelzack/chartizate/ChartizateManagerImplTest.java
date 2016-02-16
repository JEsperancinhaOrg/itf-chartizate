package com.steelzack.chartizate;

import android.app.Application;
import android.graphics.Color;
import android.test.ApplicationTestCase;

import com.steelzack.chartizate.distributions.ChartizateDistributionType;

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
    public void testGenerateConvertedImage_CyanBlack() throws Exception {
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
    public void testGenerateConvertedImage_RealExample1() throws Exception {
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
                new File(getContext().getCacheDir(),"testRealExample1.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImage_RealExample1_Red() throws Exception {
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
                new File(getContext().getCacheDir(),"testRealExample1Red.png").getAbsolutePath() //
        );
        manager.generateConvertedImage();
    }
}