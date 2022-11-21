package dto;

public class MapResponseDto {
	private final String map;
	private final int numberOfCorrect;

	public MapResponseDto(String map) {
		this.map = map;
		this.numberOfCorrect = (int)map.chars().filter(cell -> cell == 'O').count();
	}

	public String getMap() {
		return map;
	}

	public int getNumberOfCorrect() {
		return numberOfCorrect;
	}
}
