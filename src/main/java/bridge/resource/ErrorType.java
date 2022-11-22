package bridge.resource;

public enum ErrorType {
    NUMERIC("3 ~ 20 사이의 숫자를 입력해주세요."),
    RANGE("다리 길이는 3 ~ 20 사이입니다."),
    MOVING("U(위 칸), D(아래 칸)만 입력해주세요."),
    CONTINUING("R(재시작), Q(종료)만 입력해주세요.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
