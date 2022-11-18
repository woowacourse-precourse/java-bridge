package bridge.validator;

import bridge.view.Messages;

public class Validator {
    private static int BRIDGE_MINIMUM_SIZE = 3;
    private static int BRIDGE_MAXIMUM_SIZE = 20;
    private static String UP = "U";
    private static String DOWN = "D";
    private static String RESTART = "R";
    private static String QUITE = "Q";

    public void validateInputIsNumber(String userInput) {
        for(char input : userInput.toCharArray()) {
            if(!Character.isDigit(input)) {
                throw new IllegalArgumentException(Messages.ERROR_INPUT_NUMBER.getMessage());
            }
        }
    }

    public void validateBridgeSize(String userInput) {
        validateInputIsNumber(userInput);

        int bridgeSize = StringToInteger(userInput);

        if(bridgeSize < BRIDGE_MINIMUM_SIZE || bridgeSize > BRIDGE_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(Messages.ERROR_BRIDGE_SIZE.getMessage());
        }
    }

    public void validateMove(String userInput) {
        if(!(userInput.equals(UP) || userInput.equals(DOWN))) {
            throw new IllegalArgumentException(Messages.ERROR_MOVE.getMessage());
        }
    }
    public void validateReStart(String userInput) {
        if((!userInput.equals(RESTART) || userInput.equals(QUITE))) {
            throw new IllegalArgumentException(Messages.ERROR_RESTART.getMessage());
        }
    }


    public int StringToInteger(String userInput) {
        return Integer.parseInt(userInput);
    }
}
