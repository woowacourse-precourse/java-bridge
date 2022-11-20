package bridge.view;

public enum Error {
    INPUT_NUMBER_ERROR("다리 길이는 숫자로 입력을 해주셔야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
