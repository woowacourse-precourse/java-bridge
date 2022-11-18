package bridge.dto;

public class GameResultDto {
	private final int totalTry;
	private final boolean successFlag;

	public GameResultDto(int totalTry, boolean successFlag) {
		this.totalTry = totalTry;
		this.successFlag = successFlag;
	}

	public int getTotalTry() {
		return totalTry;
	}

	public boolean getSuccessFlag() {
		return successFlag;
	}
}
