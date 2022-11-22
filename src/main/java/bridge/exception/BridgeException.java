package bridge.exception;

public class BridgeException {

    private static final String NUMBER_REGEX = "^[0-9]*$+";
    private static final String ENGLISH_REGEX = "^[A-Z]*$+";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public void checkBridgeLengthExceptions(String number) {
        checkBridgeLengthAboutOnlyNumber(number);
        checkBridgeLengthInRange(number);
    }

    public void checkBridgeMoveInputAlphabetExceptions(String movement) {
        checkBridgeMoveInputAlphabet(movement);
        checkBridgeInputAlphabetOnlyEnglish(movement);
    }

    public void checkBridgeInputGameOptionExceptions(String gameOption) {
        checkBridgeGameOptionInputAlphabet(gameOption);
        checkBridgeInputAlphabetOnlyEnglish(gameOption);

    }

    public void checkBridgeLengthInRange(String number) {
        if (Integer.parseInt(number) < 3 || Integer.parseInt(number) > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void checkBridgeLengthAboutOnlyNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자로만 구성되어야 합니다.");
        }
    }

    public void checkBridgeMoveInputAlphabet(String movement) {
        if (!movement.equals("U") && !movement.equals("D")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "U, D 중에 하나를 입력해주세요. ");
        }
    }

    public void checkBridgeGameOptionInputAlphabet(String gameOption) {
        if (!gameOption.equals("R") && !gameOption.equals("Q")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "R, Q 중에 하나를 입력해주세요. ");
        }
    }

    public void checkBridgeInputAlphabetOnlyEnglish(String input) {
        if (!input.matches(ENGLISH_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "알파벳으로만 입력해주세요. ");
        }
    }


}
