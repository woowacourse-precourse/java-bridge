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
        if(number < 3 || number > 20) {
            throw new IllegalArgumentException("3~20 사이의 숫자를 입력해주세요. ");
        }
    }







}
