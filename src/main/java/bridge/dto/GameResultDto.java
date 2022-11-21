package bridge.dto;

// todo : dto들이 dto정의에 맞게 제대로 구현되었는지 확인하자!
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
