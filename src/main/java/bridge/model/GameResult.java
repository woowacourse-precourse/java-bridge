package bridge.model;

public class GameResult {
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";

	private int numberOfAttempts;
	private String gameResult;

	public GameResult() {
		this.gameResult = SUCCESS;
		this.numberOfAttempts = 0;
	}

	public void addNumberOfAttempts() {
		numberOfAttempts += 1;
	}

	public void changeResultToSuccess() {
		if (!gameResult.equals(SUCCESS)) {
			gameResult = SUCCESS;
		}
	}

	public void changeResultToFail() {
		if (!gameResult.equals(FAIL)) {
			gameResult = FAIL;
		}
	}

	public boolean isGameLose() {
		return gameResult.equals(FAIL);
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public String getGameResult() {
		return gameResult;
	}
}
