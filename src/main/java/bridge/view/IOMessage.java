package bridge.view;

public enum IOMessage {
    INPUT_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    START_BRIDGE ("[ "),
    END_BRIDGE (" ]"),
    DIVIDE_BRIDGE (" | ");
    private final String message;

    IOMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
