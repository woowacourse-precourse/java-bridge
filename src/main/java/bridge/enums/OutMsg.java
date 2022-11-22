package bridge.enums;

public enum OutMsg {
	INIT("다리 건너기 게임을 시작합니다."),
	BRIDGE_SIZE_REQUEST("다리의 길이를 입력해주세요"),
	MOVE_REQUEST("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	RETRY_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	OUTPUT_BRIDGE_STATUS("최종 게임 결과"),
	OUTPUT_SUCCESS("게임 성공 여부: "),
	TRIALS("총 시도한 횟수: ");

	private String message;

	OutMsg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
