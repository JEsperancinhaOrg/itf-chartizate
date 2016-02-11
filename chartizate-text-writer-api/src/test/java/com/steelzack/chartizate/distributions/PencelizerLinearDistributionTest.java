package com.steelzack.chartizate.distributions;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.steelzack.chartizate.distributions.PencelizerLinearDistribution;

/**
 * 
 * @author joao
 *
 */
public class PencelizerLinearDistributionTest {

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
		final PencelizerLinearDistribution distribution = new PencelizerLinearDistribution(characters, 50, 10);

		char result = distribution.getCharacterFromArray().charValue();

		assertThat(result, anyOf(equalTo('e'), equalTo('f')));
	}
}
