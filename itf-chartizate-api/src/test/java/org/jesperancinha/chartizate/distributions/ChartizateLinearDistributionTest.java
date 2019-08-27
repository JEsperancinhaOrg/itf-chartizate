package org.jesperancinha.chartizate.distributions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author joao
 */
public class ChartizateLinearDistributionTest {

    @Test
    public void testGetCharacterFromArray() {
        final Character[] characters =
                new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        final ChartizateLinearDistribution distribution = new ChartizateLinearDistribution(characters, 50, 10);

        char result = distribution.getCharacterFromArray();

        assertThat(result).isIn('e', 'f');
    }

    @Test
    public void testGetCharacterFromArrayDensityFail1() {
        final Character[] characters = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        final ChartizateLinearDistribution distribution = new ChartizateLinearDistribution(
                characters,
                1,
                10
        );

        char result = distribution.getCharacterFromArray();

        assertThat(result).isEqualTo('a');
    }
}
