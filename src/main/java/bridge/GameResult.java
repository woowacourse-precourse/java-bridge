package bridge;

public class GameResult {
	private final GameResultCode gameResultCode;
	private final int retryNumber;

	public GameResult(GameResultCode gameResultCode, int retryNumber) {
		this.gameResultCode = gameResultCode;
		this.retryNumber = retryNumber;
	}

	public boolean isLosing() {
		return GameResultCode.FAIL == gameResultCode;
	}

	public GameResultCode getGameResultCode() {
		return gameResultCode;
	}

	public int getRetryNumber() {
		return retryNumber;
	}
}
