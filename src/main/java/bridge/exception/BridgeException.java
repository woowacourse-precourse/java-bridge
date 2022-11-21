package bridge.exception;

public class BridgeException {

    private static final String NUMBER_REGEX = "/^[0-9]*$/";

    private static final String ENGLISH_REGEX = "/^[A-Z]*$/";

    public void checkBridgeLengthExceptions(int number) {
        checkBridgeLength(number);
        checkBridgeLengthAboutOnlyNumber(Integer.toString(number));
    }

    public void checkBridgeMoveInputAlphabetExceptions(String movement) {
        checkBridgeMoveInputAlphabet(movement);
        checkBridgeInputAlphabetOnlyEnglish(movement);
    }

    public void checkBridgeInputGameOptionExceptions(String gameOption) {
        checkBridgeGameOptionInputAlphabet(gameOption);
        checkBridgeInputAlphabetOnlyEnglish(gameOption);
    }

    public void checkBridgeLength(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("3~20 사이의 숫자를 입력해주세요. ");
        }
    }

    public void checkBridgeLengthAboutOnlyNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("다리 길이는 숫자로만 입력해주세요. ");
        }
    }

    public void checkBridgeMoveInputAlphabet(String movement) {
        if (!movement.equals("U") && !movement.equals("D")) {
            throw new IllegalArgumentException("U, D 중에 하나를 입력해주세요. ");
        }
    }

    public void checkBridgeGameOptionInputAlphabet(String gameOption) {
        if (!gameOption.equals("R") && !gameOption.equals("Q")) {
            throw new IllegalArgumentException("R, Q 중에 하나를 입력해주세요. ");
        }
    }

    public void checkBridgeInputAlphabetOnlyEnglish(String input) {
        if (!input.matches(ENGLISH_REGEX)) {
            throw new IllegalArgumentException("알파벳으로만 입력해주세요. ");
        }
    }


}
