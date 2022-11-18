package bridge.domain;

import static bridge.utils.ErrorMessage.*;

public class BridgeSize {
    private final int bridgeSize;
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;

    public BridgeSize(String input) {
        input = input.strip();
        validateInteger(input);
        int inputNumber = Integer.parseInt(input);
        validateRange(inputNumber);
        this.bridgeSize = inputNumber;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_INTEGER);
        }
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }
}