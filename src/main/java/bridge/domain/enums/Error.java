package bridge.domain.enums;

public enum Error {

    NUMBER_RANGE_OVER("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ONLY_NUMBER("숫자만 입력해야 합니다."),
    INVALID_COMMAND("알 수 없는 명령어입니다. 올바른 명령어를 입력해주세요."),
    NULL_INPUT("값을 입력해주세요."),
    INPUT_DETERMINE("입력이 중단되었습니다. 프로그램을 종료합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
