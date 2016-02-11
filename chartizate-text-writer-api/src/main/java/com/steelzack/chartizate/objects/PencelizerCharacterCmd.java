package com.steelzack.chartizate.objects;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author joao Manages a specific character
 *
 */
public class PencelizerCharacterCmd {

	private Color backColor;

	private final Color frontColor;

	private final char character;

	/**
	 * For the main implementation, the background color isn't really necessary
	 * 
	 * @param frontColor
	 *            Front color for the character
	 * @param character
	 *            The actual character
	 */
	public PencelizerCharacterCmd(Color frontColor, char character) {
		super();
		this.frontColor = frontColor;
		this.character = character;
	}

	/**
	 * For the add on, the background color will differ
	 * 
	 * @param frontColor
	 *            Front color for the character
	 * @param backColor
	 *            The back color for the character
	 * @param character
	 *            The actual character
	 */
	public PencelizerCharacterCmd(Color frontColor, Color backColor, char character) {
		super();
		this.frontColor = frontColor;
		this.backColor = backColor;
		this.character = character;
	}

	/**
	 * Prints the character with specified configuration to the console
	 */
	public void printToCommandLine() {
		AnsiConsole.systemInstall();
		System.out.print(ansi().eraseScreen().bg(backColor).fg(frontColor).a(character).reset());
		AnsiConsole.systemUninstall();
	}
}
