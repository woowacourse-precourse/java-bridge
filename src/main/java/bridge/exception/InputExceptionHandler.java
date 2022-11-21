package bridge.exception;

public class InputExceptionHandler {

    public static void handleEmptyInputException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
    }

    public static void handleNotNumberOrAlphabetException(String input) {
        if (!(input.matches("^[0-9]+$") || input.matches("^[a-zA-Z]+$"))) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자 혹은 알파벳이 아닙니다.");
        }
    }

    public static void handleNotNumberException(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }

    public static void handleNotUpperAlphabetException(String input) {
        if (!input.matches("^[A-Z]$")) {
            throw new IllegalArgumentException("[ERROR] 입력이 대문자 알파벳이 아닙니다.");
        }
    }

    public static void handleCommonException(String input) {
        handleEmptyInputException(input);
        handleNotNumberOrAlphabetException(input);
    }

    public static void handleBridgeSizeInputException(String input) {
        handleCommonException(input);
        handleNotNumberException(input);
    }

    public static void handleMoveAndRetryException(String input) {
        handleCommonException(input);
        handleNotUpperAlphabetException(input);
    }
}
