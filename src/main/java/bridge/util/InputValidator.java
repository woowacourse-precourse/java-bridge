package bridge.util;

import bridge.model.ErrorMessage;

public class InputValidator {
    public InputValidator() {
    }

    public void validateBridgeLength(Integer input) {
        if(input < 3 || input > 20){
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.ERROR_MESSAGE_BRIDGE_LENGTH));
        }
    }

    public void validateMoving(String input) {
        if(!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.ERROR_MESSAGE_MOVING));
        }
    }

    public void validateGameCommand(String input) {
        if(!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.ERROR_MESSAGE_GAME_COMMAND));
        }
    }

}
