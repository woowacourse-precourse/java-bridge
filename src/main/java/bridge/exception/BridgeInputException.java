package bridge.exception;

import bridge.message.ErrorMessage;

public class BridgeInputException {
    public BridgeInputException() {}

    private final int bridgeStartNum = 3;
    private final int bridgeFinalNum = 20;

    // 숫자인지 아닌지 판별하는 기능
    public void validCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    // 숫자의 범위가 적절한지 판별하는 기능
    public void validNumberRange(String input) {
        int size = Integer.parseInt(input);
        if(!(bridgeStartNum <= size && size <= bridgeFinalNum)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RANGE_ERROR_MESSAGE);
        }
    }

    // 값이 비어있는지 판별하는 기능
    public void validEmpty(String input) {
        if(input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_EMPTY_ERROR_MESSAGE);
        }
    }


}
