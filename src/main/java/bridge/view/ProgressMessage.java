package bridge.view;

public enum ProgressMessage {
	GAME_START("다리 건너기 게임을 시작합니다."),
	INPUT_BRIDGE_SIZE("\n" + "다리의 길이를 입력해주세요."),
	CHOICE_MOVE_STEP("\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	CHOICE_GAME_COMMAND("\n" + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	GAME_DRAW_RESULT("최종 게임 결과"),
	GAME_SUCCESSFUL("게임 성공 여부: "),
	TOTAL_TRY_NUMBER("총 시도한 횟수: "),
	INPUT_AGAIN("값을 다시 입력해주세요.");

	private final String message;

	ProgressMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
