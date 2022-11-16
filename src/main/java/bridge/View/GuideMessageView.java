package bridge.View;

public enum GuideMessageView {
	START_BRIDGE_GAME_GUIDE_MESSAGE("다리 건너기 게임을 시작합니다."),
	BRIDGE_LENGTH_GUIDE_MESSAGE("다리의 길이를 입력해주세요."),
	SELECT_MOVE_GUIDE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	RE_OR_END_GUIDE_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	GAME_RESULT_GUIDE_MESSAGE("최종 게임 결과"),
	GAME_SUCCESS_GUIDE_MESSAGE("게임 성공 여부: 성공"),
	GAME_FAIL_GUIDE_MESSAGE("게임 성공 여부: 실패");

	private String message;
	GuideMessageView(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
