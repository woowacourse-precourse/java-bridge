package bridge.type;

public enum GuideMessage {

    BRIDGE_GAME_START("다리 건너기 게임을 시작합니다."),

    INPUT_BRIDGE_LENGTH("다리 길이를 입력해주세요."),

    INPUT_MOVE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
