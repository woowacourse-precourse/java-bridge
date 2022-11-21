package bridge.constant;

public enum InputValidationError {
    ERROR_BRIDGE_SIZE(new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")),
    ERROR_MOVE(new IllegalArgumentException("[ERROR] 움직임 입력은 U나 D여야 합니다.")),
    ERROR_GAME_COMMAND(new IllegalArgumentException("[ERROR] 재시도 여부는 R이나 Q여야 합니다."));

    public IllegalArgumentException exception;

    InputValidationError(IllegalArgumentException exception) {
        this.exception = exception;
    }
}
