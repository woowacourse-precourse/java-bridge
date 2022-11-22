package bridge.view;

public enum Error {
    INPUT_NUMBER_ERROR("[ERROR] 올바른 형식의 다리 길이를 입력하셔야 합니다."),
    INPUT_NUMBER_RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_MOVING_INFORMATION_ERROR("[ERROR] 올바른 다리 이동 정보를 입력해주셔야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
