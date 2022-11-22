package bridge.view;

import bridge.controller.GameState;

public enum GameResult {
	GAME_WIN("성공", GameState.SUCCESS_END), GAME_LOSE("실패", GameState.FAIL_END);

	private final String comment;
	private final GameState result;

	GameResult(String comment, GameState result) {
		this.comment = comment;
		this.result = result;
	}

	public String getComment() {
		return comment;
	}

	public static String findResultName(GameState result) {
		if (GameResult.GAME_LOSE.result.equals(result)) {
			return GameResult.GAME_LOSE.getComment();
		}
		return GameResult.GAME_WIN.getComment();
	}
}
