package bridge.exception;

import bridge.message.ErrorMessage;

public class BridgeInputException {
    public BridgeInputException() {}



    // 숫자인지 아닌지 판별하는 기능
    public void validCharacter(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_NUMBER_ERROR_MESSAGE);
            }
        }
    }




}
