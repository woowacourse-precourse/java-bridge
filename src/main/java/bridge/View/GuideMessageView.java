package bridge.View;

public enum GuideMessageView {
	START_BRIDGE_GAME_GUIDE_MESSAGE("다리 건너기 게임을 시작합니다."),
	BRIDGE_LENGTH_GUIDE_MESSAGE("다리의 길이를 입력해주세요."),
	SELECT_MOVE_GUIDE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");
	private String message;
	GuideMessageView(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
