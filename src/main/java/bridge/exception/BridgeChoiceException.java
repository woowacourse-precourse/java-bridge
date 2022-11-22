package bridge.exception;

import static bridge.enums.BridgeType.*;

public class BridgeChoiceException extends Exceptions{
    private static final String NOT_RIGHT_BRIDGE_COMMENT = "다리는 U 또는 D로 입력해야 합니다. ";

    public String validate(String input){
        if(isNotDown(input) && isNotUp(input)) notBridgeException();
        return input;
    }

    private boolean isNotUp(String input){
        return !input.equals(UPPER.getCommand());
    }

    private boolean isNotDown(String input){
        return !input.equals(LOWER.getCommand());
    }

    private void notBridgeException(){
        executeException(NOT_RIGHT_BRIDGE_COMMENT);
    }
}
