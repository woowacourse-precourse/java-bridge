package bridge.view;

public enum Messages {
    // for inputView
    SCAN_BRIDGE_SIZE("\n다리의 길이를 입력해주세요."),
    SCAN_MOVING_COMMAND("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    // for outputView
    PRINT_GAME_START("다리 건너기 게임을 시작합니다."),
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
