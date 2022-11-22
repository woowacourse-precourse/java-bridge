package bridge.dto;

public class GameResultDto {
	private final int totalTry;
	private final boolean isGameClear;

	public GameResultDto(int totalTry, boolean isGameClear) {
		this.totalTry = totalTry;
		this.isGameClear = isGameClear;
	}

	public int getTotalTry() {
		return totalTry;
	}

	public boolean isGameClear() {
		return isGameClear;
	}
}
