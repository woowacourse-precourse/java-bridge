package bridge.domain;

public enum GameSituation {
	ON_GOING("진행중"), FAIL("실패"), SUCCESS("성공");

	private final String status;

	GameSituation(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
