package bridge.ui.Input;

public class BridgeLength extends Repetitor{
    private static final String ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

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
        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
