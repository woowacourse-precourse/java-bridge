package bridge.type;

public enum ErrorType {
    NOT_NUMBER_INPUT("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다."),
    OVER_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_MOVING_INPUT("[ERROR] 이동할 칸은 U, D 중 하나여야 합니다."),
    NOT_COMMAND_INPUT("[ERROR] 게임 재시도 여부는 R, Q 중 하나여야 합니다.");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
