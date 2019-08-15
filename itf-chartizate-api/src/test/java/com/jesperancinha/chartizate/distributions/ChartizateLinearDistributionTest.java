package com.jesperancinha.chartizate.distributions;

import org.junit.Test;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author joao
 */
public class ChartizateLinearDistributionTest {

    @Test
    public void testGetCharacterFromArray() throws Exception {
        final Character[] characters =
                new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        final ChartizateLinearDistribution distribution = new ChartizateLinearDistribution(characters, 50, 10);

        char result = distribution.getCharacterFromArray();

        assertThat(result, anyOf(equalTo('e'), equalTo('f')));
    }

    @Test
    public void testGetCharacterFromArray_DensityFail1() throws Exception {
        final Character[] characters = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        final ChartizateLinearDistribution distribution = new ChartizateLinearDistribution(
                characters,
                1,
                10
        );

        char result = distribution.getCharacterFromArray();

        assertThat(result, equalTo('a'));
    }
}
