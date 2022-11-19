package bridge.model;

public class GameResult {
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";

	private String result;
	private int numberOfAttempts;

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

	public String getResult() {
		return result;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}
}
