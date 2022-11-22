package bridge.input;

import static bridge.output.BridgeState.*;

import bridge.gameplay.GameState;

public enum InputError {
    OUT_OF_BOUND("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ONLY_ONE_INPUT_ALLOWED("한 글자만 입력해야 합니다."),
    UNENTERED("아무것도 입력되지 않았습니다."),
    NOT_NUMBER("숫자만 입력해야 합니다.", "0123456789"),
    WRONG_MOVING_INPUT("명시된 키만 입력해야 합니다.",
            UP.getBridgeMark() + DOWN.getBridgeMark()),
    WRONG_GAME_COMMAND_INPUT("명시된 커맨드만 입력해야 합니다. ",
            GameState.QUIT_COMMAND + GameState.RETRY_COMMAND);

    final String nonAllowedInput;
    final String errorMessage;

    InputError(String errorMessage, String allowedInput) {
        nonAllowedInput = "[^" + allowedInput + "]";
        this.errorMessage = "[ERROR] " + errorMessage;
    }
    InputError(String errorMessage) {
        nonAllowedInput = "";
        this.errorMessage = "[ERROR] " + errorMessage;
    }

    public static void nonAllowedInputCheck(String input, InputError inputError) {
        String onlyNumber = input.replaceAll(inputError.nonAllowedInput, "");
        if (input.length() != onlyNumber.length()) {
            makeError(inputError);
        }
    }
    public static void inputLengthCheck(String input) {
        if (input.length() != 1) {
            makeError(ONLY_ONE_INPUT_ALLOWED);
        }
    }
    public static void boundaryCheck(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            makeError(OUT_OF_BOUND);
        }
    }
    public static void makeError(InputError inputError) {
        throw new IllegalArgumentException(inputError.errorMessage);
    }
}

