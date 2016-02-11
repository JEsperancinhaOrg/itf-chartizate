package com.steelzack.chartizate.objects;

import org.fusesource.jansi.Ansi.Color;
import org.junit.Test;

import com.steelzack.chartizate.objects.ChartizateCharacterCmd;

/**
 * 
 * @author joao
 *
 */
public class ChartizateCharacterCmdTest {

	@Test
	public void testPrintToCommandLine() throws Exception {
		final ChartizateCharacterCmd pc = new ChartizateCharacterCmd(Color.RED, Color.BLACK, 'a');
		pc.printToCommandLine();
	}
}
