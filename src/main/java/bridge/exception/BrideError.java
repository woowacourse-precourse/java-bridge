package bridge.exception;

public enum BrideError {
    IS_NOT_NUMERIC("다리 길이의 입력 값이 숫자가 아닙니다."),
    INVALID_RANGE("다리 길이의 입력 값이 3이상 20이하가 아닙니다."),
    INVALID_RANDOM_NUMBER("무작위 값이 0또는 1이 아닙니다."),
    IS_NOT_ONE_CHARACTER("이동할 칸 입력 값의 길이가 1이 아닙니다."),
    INVALID_DIRECTION("이동할 칸 입력 값이 올바르지 않습니다."),
    INVALID_GAME_STATUS("게임 재시도 입력 값이 올바르지 않습니다."),
    UNINITIALIZED_BRIDGE("이전 게임의 다리 결과가 초기화 되지 않았습니다.");

    private final String errorMessage;

    BrideError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
