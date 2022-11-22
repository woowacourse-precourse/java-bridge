package bridge;

public enum Errors {
    NULL_ERROR("아무것도 입력하지 않으셨습니다."),
    NOT_NUMBER_ERROR("숫자만 입력하세요."),
    RANGE_SIZE_ERROR("다리 길이는 3~20 사이만 입력 가능합니다."),
    MOVE_ERROR("U 또는 D만 입력 가능합니다."),
    REPLAY_ERROR("R 또는 Q만 입력 가능합니다.");

    private final String error;

    Errors(final String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
