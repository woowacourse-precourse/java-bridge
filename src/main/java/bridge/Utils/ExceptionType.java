package bridge.Utils;

public enum ExceptionType {

    NOT_NUMBER("입력한 값이 숫자가 아닙니다."),
    LOWER_THAN_MIN_BRIDGE_SIZE("입력한 값이 다리의 최소 길이(3)보다 작습니다."),
    HIGHER_THAN_MAX_BRIDGE_SIZE("입력한 값이 다리의 최대 길이(20)보다 큽니다."),
    NOT_ONLY_ALPHABET("입력한 값에 알파벳 외의 다른 문자가 존재합니다."),
    NOT_ONE_ALPHABET("입력한 값이 한 개의 알파벳이 아닙니다."),
    NOT_UPPER_ALPHABET("입력한 값이 대문자가 아닙니다."),
    NOT_MOVING_ALPHABET("입력한 값이 U와 D가 아닌 다른 값입니다."),
    NOT_GAME_COMMAND_ALPHABET("입력한 값이 R과 Q가 아닌 다른 값입니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
