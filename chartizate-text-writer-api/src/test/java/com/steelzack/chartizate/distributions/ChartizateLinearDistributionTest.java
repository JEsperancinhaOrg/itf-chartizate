package com.steelzack.chartizate.distributions;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.steelzack.chartizate.distributions.ChartizateLinearDistribution;

/**
 * 
 * @author joao
 *
 */
public class ChartizateLinearDistributionTest {

	@Test
	public void testGetCharacterFromArray() throws Exception {
		final Character[] characters = new Character[] { //
				new Character('a'), //
				new Character('b'), //
				new Character('c'), //
				new Character('d'), //
				new Character('e'), //
				new Character('f'), //
				new Character('g'), //
				new Character('h'), //
				new Character('i'), //
				new Character('j'), //
				new Character('k') //
		};
		final ChartizateLinearDistribution distribution = new ChartizateLinearDistribution(characters, 50, 10);

		char result = distribution.getCharacterFromArray().charValue();

		assertThat(result, anyOf(equalTo('e'), equalTo('f')));
	}
	
	@Test
	public void testGetCharacterFromArray_DensityFail1() throws Exception {
		final Character[] characters = new Character[] { //
				new Character('a'), //
				new Character('b'), //
				new Character('c'), //
				new Character('d'), //
				new Character('e'), //
				new Character('f'), //
				new Character('g'), //
				new Character('h'), //
				new Character('i'), //
				new Character('j'), //
				new Character('k') //
		};
		final ChartizateLinearDistribution distribution = new ChartizateLinearDistribution( //
				characters, //
				1, //
				10 //
		);

		char result = distribution.getCharacterFromArray().charValue();

		assertThat(result, equalTo('a'));
	}
}
