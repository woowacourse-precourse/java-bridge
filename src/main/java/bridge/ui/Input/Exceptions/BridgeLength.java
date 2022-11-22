package bridge.ui.Input.Exceptions;

import bridge.ui.Input.Repetitor;

public class BridgeLength extends Repetitor {

    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUM_LENGTH = 20;
    private static final String ERROR_MESSAGE =
            "[ERROR] 다리 길이는 " + MINIMUM_LENGTH + "부터 " + MAXIMUM_LENGTH + " 사이의 숫자여야 합니다.";

    @Override
    protected String checkInputException(String input) throws IllegalArgumentException {
        int tmpInteger = makeSureNumber(input);
        checkLengthRange(tmpInteger);

        return input;
    }

    private int makeSureNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkLengthRange(int input) throws IllegalArgumentException{
        if (!(input >= MINIMUM_LENGTH && input <= MAXIMUM_LENGTH)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
