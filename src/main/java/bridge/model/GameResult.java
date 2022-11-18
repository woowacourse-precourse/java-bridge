package bridge.model;

public class GameResult {

	private String result;
	private int numberOfAttempts;

	public GameResult() {
		this.result = "";
		this.numberOfAttempts = 0;
	}

	public void addNumberOfAttempts() {
		numberOfAttempts += 1;
	}

	public void changeResultToSuccess() {
		if (!result.equals("성공")) {
			result = "성공";
		}
	}

	public void changeResultToFail() {
		if (!result.equals("실패")) {
			result = "실패";
		}
	}

	public String getResult() {
		return result;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}
}
