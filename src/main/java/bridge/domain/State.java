package bridge.domain;

public enum State {
	PLAY("실행"),
	MOVE_FAILED("이동 실패"),
	CLEAR("성공"),
	FAILED_CLEAR("실패");

	private final String message;

	State(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
