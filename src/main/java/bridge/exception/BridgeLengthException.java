package bridge.exception;

import java.util.regex.Pattern;

public class BridgeLengthException extends Exceptions{
    private static final int MINIMUM_NUMBER_IN_RANGE = 3;
    private static final int MAXIMUM_NUMBER_IN_RANGE = 20;
    private static final String LENGTH_INPUT_NOT_RIGHT_COMMENT = "입력은 3부터 20중의 정수여야 합니다.";

    public int validate(String input){
        if(isNotNumber(input) || isOutOfRange(input)) notBridgeLengthException();
        return valueOf(input);
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[0-9]*$", input);
    }

    private boolean isOutOfRange(String input){
        return valueOf(input) < MINIMUM_NUMBER_IN_RANGE || valueOf(input) > MAXIMUM_NUMBER_IN_RANGE;
    }

    private int valueOf(String input){
        return Integer.parseInt(input);
    }

    private void notBridgeLengthException(){
        executeException(LENGTH_INPUT_NOT_RIGHT_COMMENT);
    }
}
