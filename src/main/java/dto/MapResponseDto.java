package dto;

import bridge.MoveResult;

public class MapResponseDto {
	private final String map;
	private final int numberOfCorrect;

	public MapResponseDto(MoveResult moveResult) {
		this.map = moveResult.getMap();
		this.numberOfCorrect = moveResult.getNumberOfCorrect();
	}

	public String getMap() {
		return map;
	}

	public int getNumberOfCorrect() {
		return numberOfCorrect;
	}
}
