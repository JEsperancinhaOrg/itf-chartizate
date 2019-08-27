package org.jesperancinha.chartizate.objects;

import org.fusesource.jansi.Ansi.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author joao
 */
public class ChartizateCharacterCmdTest {

    @Test
    public void testPrintToCommandLine() {
        try {
            final ChartizateCharacterCmd pc = new ChartizateCharacterCmd(Color.RED, Color.BLACK, 'a');
            pc.printToCommandLine();
        } catch (Exception e) {
            fail("Exception thrown!", e);
        }
    }
}
