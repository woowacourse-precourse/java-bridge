package bridge.message;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR]"),
    INPUT_SIZE_OUT_OF_RANGE("잘못된 입력입니다. 다리의 길이가 범위에 해당되지 않습니다."),
    INPUT_SIZE_NOT_INTEGER("잘못된 입력입니다. 다리의 길이 형식인 정수 형식이 아닙니다."),
    IMMOVABLE_STATE("잘못된 실행입니다. 게임에서 더이상 이동할 수 없습니다."),
    NEGATIVE_BRIDGE_LENGTH("잘못된 입력입니다. 다리에서의 위치가 양수가 아닙니다."),
    UNEXPECTED_BRIDGE_VALUE("잘못된 입력입니다. 입력한 값에 해당하는 위치 문자가 존재하지 않습니다."),
    UNEXPECTED_BRIDGE_CHARACTER("잘못된 입력입니다. 입력한 글자에 해당하는 위치 문자가 존재하지 않습니다."),
    UNEXPECTED_GAME_COMMAND("잘못된 입력입니다. 입력한 게임 제어 문자가 존재하지 않습니다."),
    GAME_STOP("잘못된 실행입니다. 게임이 이미 종료되었습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", ERROR_PREFIX.value(), message);
    }

    public String value() {
        return message;
    }
}
