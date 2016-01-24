package com.steelzack.pencelizer;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.CYAN;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author joao
 * Manages a specific character
 *
 */
public class PencelizerCharacter {

	private Color frontColor;

	private Color backColor;

	private char character;

	public PencelizerCharacter(Color frontColor, Color backColor, char character) {
		super();
		this.frontColor = frontColor;
		this.backColor = backColor;
		this.character = character;
	}

	// For testing purposes only
	public static void main(String[] args) {
		final PencelizerCharacter character = new PencelizerCharacter(YELLOW, CYAN, 'A');
		character.printToCommandLine();
	}

	/**
	 * Prints the character with specified configuration to the console
	 */
	public void printToCommandLine() {
		AnsiConsole.systemInstall();
		System.out.println(ansi().eraseScreen().bg(backColor).fg(frontColor).a(character).reset());
		AnsiConsole.systemUninstall();
	}
}
