package bridge.enums;

public enum InputMessage {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    RETRY_MESSAGE("총 시도한 횟수: "),
    INIT_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    INIT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INIT_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
