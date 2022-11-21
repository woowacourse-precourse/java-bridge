package bridge.View;

public enum ExceptionMessage {
    NUMERIC_EXCEPTION_MESSAGE("[ERROR] 다리 길이는 숫자여야 합니다."),
    RANGE_EXCEPTION_MESSAGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_EXCEPTION_MESSAGE("[ERROR] 이동할 칸은 U 또는 D로 입력할 수 있습니다."),
    GAME_COMMAND_EXCEPTION_MESSAGE("[ERROR] 게임을 재시도하려면 R, 종료하려면 Q를 입력해야 합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
