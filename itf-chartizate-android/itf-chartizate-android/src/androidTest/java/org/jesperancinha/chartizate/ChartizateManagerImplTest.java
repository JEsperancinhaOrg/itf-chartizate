package org.jesperancinha.chartizate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.test.runner.AndroidJUnit4;

import org.jesperancinha.chartizate.distributions.ChartizateDistributionType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(AndroidJUnit4.class)
public class ChartizateManagerImplTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File targetFile;

    @Before
    public void setUp() throws IOException {
        targetFile = folder.newFile();
    }

    @Test
    public void testGenerateConvertedImageCyanBlack() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.chartizatecyanblack);

        assertThat(imageFullStream).isNotNull();

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                50,
                10,
                ChartizateDistributionType.Linear,
                "Arial",
                5,
                Character.UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageRealExample1() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample1);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageRealExample1Red() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample1);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.RED,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }


    @Test
    public void testGenerateConvertedImageLatinRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageArabicRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.ARABIC,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageHebrewRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.HEBREW,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSyriacRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.SYRIAC,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageSamaritanRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.SAMARITAN,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageMandaicRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.MANDAIC,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageThaanaRealexample2() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample2);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                100,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.THAANA,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    @Test
    public void testGenerateConvertedImageRealExample1DensityFail1() throws Exception {
        final InputStream imageFullStream = getByteArrayInputStreamFromResource(R.raw.realexample1);

        assertThat(imageFullStream);

        final ChartizateManagerImpl manager = new ChartizateManagerImpl(
                Color.BLACK,
                1,
                100,
                ChartizateDistributionType.Linear,
                "Times New Roman",
                20,
                Character.UnicodeBlock.LATIN_EXTENDED_A,
                imageFullStream,
                targetFile.getAbsolutePath()
        );
        manager.generateConvertedImage();
    }

    private ByteArrayInputStream getByteArrayInputStreamFromResource(int resource) {
        final Context appContext = androidx.test.InstrumentationRegistry.getTargetContext();
        final Drawable drawable = appContext.getDrawable(resource);
        assertThat(drawable).isNotNull();
        final Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
        final byte[] bitmapdata = bos.toByteArray();
        return new ByteArrayInputStream(bitmapdata);
    }
}