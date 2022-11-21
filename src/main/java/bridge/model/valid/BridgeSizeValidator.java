package bridge.model.valid;

public class BridgeSizeValidator implements InputValidator {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String BRIDGE_SIZE_INPUT_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    @Override
    public void validateInput(String input) throws IllegalArgumentException{
        checkParsableInt(input);
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR_MESSAGE);
        }
    }

    private void checkParsableInt(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString(){
        return String.format("< BridgeSizeValidator min=%d max=%d >", MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE);
    }
}
