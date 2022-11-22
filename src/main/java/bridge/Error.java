package bridge;

public enum Error {

    ERROR_INPUT_U_OR_D("[ERROR] U 또는 D를 입력해주세요"),
    ERROR_SIZE_BRIDGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");




    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
