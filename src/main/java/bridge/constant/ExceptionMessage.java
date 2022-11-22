package bridge.constant;

public enum ExceptionMessage {
    INPUT_WRONG_BRIDGE_LENGTH_MESSAGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_WRONG_BRIDGE_MOVEMENT_MESSAGE("위 칸으로 이동할 시 'U', 아래 칸으로 이동할 시 'D'를 입력해 주셔야 합니다."),
    INPUT_WRONG_RETRY_ANSWER_MESSAGE("게임 재시도 시 'R', 종료 시 'Q'를 입력해 주셔야 합니다.");

    private final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_TAG + message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}
