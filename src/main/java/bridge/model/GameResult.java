package bridge.model;

public class GameResult {
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";

	private int numberOfAttempts;
	private String result;

	public GameResult() {
		this.result = SUCCESS;
		this.numberOfAttempts = 0;
	}

	public void addNumberOfAttempts() {
		numberOfAttempts += 1;
	}

	public void changeResultToSuccess() {
		if (!result.equals(SUCCESS)) {
			result = SUCCESS;
		}
	}

	public void changeResultToFail() {
		if (!result.equals(FAIL)) {
			result = FAIL;
		}
	}

	public boolean isGameLose() {
		return result.equals(FAIL);
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public String getResult() {
		return result;
	}
}
