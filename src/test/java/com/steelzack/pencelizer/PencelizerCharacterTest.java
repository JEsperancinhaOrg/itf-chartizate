package com.steelzack.pencelizer;

import org.fusesource.jansi.Ansi.Color;
import org.junit.Test;

public class PencelizerCharacterTest {

	@Test
	public void testPrintToCommandLine() throws Exception {
		final PencelizerCharacter pc = new PencelizerCharacter(Color.RED, Color.BLACK, 'a');
		pc.printToCommandLine();
	}

}
