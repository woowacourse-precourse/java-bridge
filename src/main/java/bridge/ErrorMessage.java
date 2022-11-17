package bridge;

public enum ErrorMessage {
    NotNumberFormat("숫자를 입력해주세요."),
    NotValidBridgeSize("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NotValidRandomNumber("유효하지 않은 난수가 생성되었습니다.");

    private final String format = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = format + message;
    }

    public String getMessage() {
        return message;
    }
}
