package bridge.enumeration;

public enum ErrorMessage {
    NOT_NUMBER("다리 길이는 숫자로 입력해야 합니다."),
    OUT_OF_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_CHARACTER("한 문자를 입력해야 합니다."),
    INVALID_MOVE("이동하기 위해선 U 또는 D를 입력해야 합니다."),
    INVALID_RETRY_COMMAND("게임 재시작 또는 종료를 하려면 R 또는 Q를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}