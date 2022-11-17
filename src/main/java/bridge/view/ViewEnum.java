package bridge.view;

public enum ViewEnum {
    INPUT_BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_USER_MOVE_BRIDGE_MESSAGE("이동할 칸을 입력해주세요. (위: U, 아래: D)"),

    OUTPUT_GAME_START_MESSAGE("다리 건너기 게임을 시작합니다");

    private String message;

    ViewEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
