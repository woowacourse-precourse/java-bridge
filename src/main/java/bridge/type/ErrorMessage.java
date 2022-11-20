package bridge.type;

public enum ErrorMessage {

    ERROR("[ERROR] "),

    BRIDGE_SIZE_NUMERIC(ERROR.getMessage() + "다리 길이는 숫자만 입력 가능합니다."),

    BRIDGE_SIZE_BOUNDARY(ERROR.getMessage() + "다리 길이는 3이상 20이하여야 합니다."),

    WRONG_DIRECTION(ERROR.getMessage() + "이동할 칸은 위(U), 아래(D) 둘 중 하나여야 합니다."),

    WRONG_COMMAND(ERROR.getMessage() + "명령어는 재시도(R), 종료(Q)만 입력 가능합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
