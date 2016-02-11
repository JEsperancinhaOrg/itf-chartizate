package com.steelzack.chartizate;

public interface PencelizerEncodingManager {

	int getCharacterFullness(Character character);

	void init();

	Character[] getCharacters();

}