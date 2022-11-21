package dto;

import bridge.MapRenderer;

public class MapResponseDto {
	private final String map;
	private final int numberOfCorrect;

	public MapResponseDto(MapRenderer mapRenderer) {
		this.map = mapRenderer.getMap();
		this.numberOfCorrect = (int)map.chars().filter(cell -> cell == 'O').count();
	}

	public String getMap() {
		return map;
	}

	public int getNumberOfCorrect() {
		return numberOfCorrect;
	}
}
