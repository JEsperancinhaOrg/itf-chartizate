package com.steelzack.pencelizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.lang.Character.UnicodeBlock;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JLabel;

/**
 * 
 * @author joao
 *
 */
public class PencelizerEncodingManager {

	private final UnicodeBlock block;

	private Set<Character> orderedCharacters = new TreeSet<Character>(getComparator());

	private Character[] characters;
	
	private final PencelizerFontManager fontManager;

	private int maximumHeight = 0;

	public PencelizerEncodingManager(UnicodeBlock block, PencelizerFontManager fontManager) {
		super();
		this.block = block;
		this.fontManager = fontManager;
	}

	public void init() {
		for (int codePoint = Character.MIN_CODE_POINT; codePoint <= Character.MAX_CODE_POINT; codePoint++) {
			if (block == UnicodeBlock.of(codePoint)) {
				orderedCharacters.add(((char) codePoint));

				int height = fontManager.getCharacterHeight((char) codePoint);
				if (height > maximumHeight) {
					maximumHeight = height;
				}
			}
		}
		characters = orderedCharacters.toArray(new Character[0]);
	}

	private Comparator<Character> getComparator() {
		return new Comparator<Character>() {
			public int compare(Character o1, Character o2) {
				double fullNess1 = getCharacterFullness(o1);
				double fullNess2 = getCharacterFullness(o2);
				Integer comparisonResult = (Integer) ((fullNess1 < fullNess2) ? -1 : 0);
				if (comparisonResult == 0) {
					comparisonResult = o1.compareTo(o2);
				}

				return comparisonResult;
			}
		};
	}

	protected int getCharacterFullness(Character character) {
		Font font = fontManager.getFont();
		FontMetrics metrics = new JLabel().getFontMetrics(font);
		int width = Math.abs(metrics.stringWidth(character.toString()));
		int height = metrics.getMaxAscent();
		if (width > 0) {
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bi.createGraphics();
			g2d.setFont(font);
			g2d.setColor(Color.black);
			g2d.drawString(character.toString(), 0, height);
			g2d.dispose();
			double total = getMaximumHeight() * width;
			double fullNess = 0;
			// System.out.println(height);
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					fullNess += bi.getRGB(i, j) != 0 ? 1d : 0d;
					// System.out.print(bi.getRGB(i, j) != 0 ? "1" : "0");
				}
				// System.out.print("\n");
			}
			return (int) (fullNess / total * 1000);
		} else {
			return -1;
		}
	}

	protected int getMaximumHeight() {
		return maximumHeight;
	}

	public Character[] getCharacters() {
		return characters;
	}
}