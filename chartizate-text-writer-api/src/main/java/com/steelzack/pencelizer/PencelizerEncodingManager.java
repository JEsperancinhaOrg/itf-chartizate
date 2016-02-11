package com.steelzack.pencelizer;

public interface PencelizerEncodingManager {

	int getCharacterFullness(Character character);

	void init();

	Character[] getCharacters();

}