package bridge.domain;

import bridge.Enum.Error;
import bridge.Enum.Number;

public class BridgeSizeInput {
    private final int bridgeSize;

    public BridgeSizeInput(String input){
        isEmpty(input);
        int size = isInteger(input);
        isNumberInRange(size);
        this.bridgeSize = size;
    }

    private void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Error.INPUT_BLANK.getMessage());
        }
    }

    private Integer isInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE.getMessage());
        }
    }

    private void isNumberInRange(int number) {
        if ((number > Number.MAX.getValue() || number < Number.MIN.getValue())) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE.getMessage());
        }
    }
}
