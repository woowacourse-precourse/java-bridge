package bridge.enums;

public enum Message {
	HEADER_START("다리 건너기 게임을 시작합니다."),
	REQUEST_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
	REQUEST_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	REQUEST_RETRY("게임을 다시 시도할 지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	RESULT_TRY("총 시도한 횟수: "),
	RESULT_SUCCESS("최종 게임 결과\n게임 성공 여부: 성공"),
	RESULT_FAIL("최종 게임 결과\n게임 성공 여부: 실패");

	private final String value;

	Message(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
