package bridge.ui;

public enum OutputMessage {
	START_GAME("다리 건너기 게임을 시작합니다"),
	INPUT_BRIDGE("다리의 길이를 입력해주세요."),
	SELECT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	RESTART_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	RESULT_GAME("최종 게임 결과"),
	IS_SUCCESS("게임 성공 여부: "),
	STATS_GAME("총 시도한 횟수: "),
	LEFT("[ "),
	MIDDLE(" | "),
	RIGHT(" ]"),
	BLANK(" ");

	private String msg;

	private OutputMessage(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}
}
