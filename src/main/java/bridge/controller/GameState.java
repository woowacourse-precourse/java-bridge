package bridge.controller;

public enum GameState {
	CONTINUATION(""), RETRY("R"), SUCCESS_END(""), FAIL_END(""), SELECT_GAME_COMMAND("");

	private final String code;

	GameState(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
