package com.jesperancinha.chartizate.objects;

import org.fusesource.jansi.Ansi.Color;
import org.junit.Test;

/**
 * @author joao
 */
public class ChartizateCharacterCmdTest {

    @Test(expected = Test.None.class)
    public void testPrintToCommandLine() throws Exception {
        final ChartizateCharacterCmd pc = new ChartizateCharacterCmd(Color.RED, Color.BLACK, 'a');
        pc.printToCommandLine();
    }
}
