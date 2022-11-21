package bridge.util;

import bridge.view.Message;

public class InputValidator {
    public InputValidator() {
    }

    public void validateBridgeLength(String input) {
        int value = 0;
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(String.valueOf(Message.ERROR_MESSAGE_BRIDGE_LENGTH));
        }
        value = Integer.parseInt(input);
        if(value >= 3 && value <= 20) return;
        throw new IllegalArgumentException(String.valueOf(Message.ERROR_MESSAGE_BRIDGE_LENGTH));
    }

    public void validateMoving(String input) {
        if(!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException(String.valueOf(Message.ERROR_MESSAGE_MOVING));
        }
    }

    public void validateGameCommand(String input) {
        if(!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException(String.valueOf(Message.ERROR_MESSAGE_GAME_COMMAND));
        }
    }

}
