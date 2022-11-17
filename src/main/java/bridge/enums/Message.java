package bridge.enums;

public enum Message {
	GAME_START_MSG("다리 건너기 게임을 시작합니다."),
	BRIDGE_SIZE_MSG("다리의 길이를 입력해주세요."),
	MOVING_MSG("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	RESTART_MSG("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	GAME_RESULT_PREV_MSG("최종 게임 결과"),
	GAME_RESULT_STATE_MSG("게임 성공 여부: "),
	GAME_RESULT_TRY_MSG("총 시도한 횟수: ");


	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
