package bridge.enums;

public enum InputMsg {
    LINE_BREAK("\n"),
    MSG_INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MSG_INPUT_MOVING_CELL("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    MSG_INPUT_GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    InputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
