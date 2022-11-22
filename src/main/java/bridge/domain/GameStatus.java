package bridge.domain;

public enum GameStatus {
	PASS( ""),
	CLEAR("성공"),
	END("실패");


	private final String message;

	GameStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
