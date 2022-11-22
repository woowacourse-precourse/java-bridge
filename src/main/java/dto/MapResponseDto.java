package dto;

import bridge.MapRenderer;

public class MapResponseDto {
	private final String map;

	public MapResponseDto(MapRenderer mapRenderer) {
		this.map = mapRenderer.getMap();
	}

	public String getMap() {
		return map;
	}
}
