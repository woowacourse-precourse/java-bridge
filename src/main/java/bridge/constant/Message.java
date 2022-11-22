package bridge.constant;

public enum Message {
    GREETING("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    ERROR_BRIDGE_SIZE_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
