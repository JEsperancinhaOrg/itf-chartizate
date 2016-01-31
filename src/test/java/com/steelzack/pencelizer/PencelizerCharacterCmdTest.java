package com.steelzack.pencelizer;

import org.fusesource.jansi.Ansi.Color;
import org.junit.Test;

/**
 * 
 * @author joao
 *
 */
public class PencelizerCharacterCmdTest {

	@Test
	public void testPrintToCommandLine() throws Exception {
		final PencelizerCharacterCmd pc = new PencelizerCharacterCmd(Color.RED, Color.BLACK, 'a');
		pc.printToCommandLine();
	}
}
