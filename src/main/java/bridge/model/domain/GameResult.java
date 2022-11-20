package bridge.model.domain;

public class GameResult {
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";

	private int numberOfAttempts;
	private boolean rightChoice;
	private String result;

	public GameResult() {
		this.numberOfAttempts = 0;
		this.rightChoice = true;
		this.result = SUCCESS;
	}

	public void addNumberOfAttempts() {
		numberOfAttempts += 1;
	}

	public void chooseStairs(boolean isEqual) {
		rightChoice = isEqual;
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

	public boolean isRightChoice() {
		return rightChoice;
	}

	public String getResult() {
		return result;
	}
}
