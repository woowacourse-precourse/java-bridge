package bridge;

public enum GameResultCode {
	SUCCESS("성공"),
	FAIL("실패");

	private final String resultMessage;

	GameResultCode(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResultMessage() {
		return resultMessage;
	}
}
