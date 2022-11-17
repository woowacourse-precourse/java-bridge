package bridge.view;

public enum ProgressMessage {
	GAME_START("다리 건너기 게임을 시작합니다."),
	GAME_DRAW_RESULT("최종 게임 결과"),
	GAME_SUCCESSFUL("게임 성공 여부: "),
	TOTAL_TRY_NUMBER("총 시도한 횟수: ");

	private final String message;

	ProgressMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
