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







}
