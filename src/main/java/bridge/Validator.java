package bridge;

import java.util.regex.Pattern;

import static bridge.GameMessage.ERROR_MESSAGE;


public class Validator {
    private static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;
    public void validateNumeric(String input){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 형태가 아닙니다");
        }
    }

    public void validateBridgeSize(String input){
        int bridgeSize = Integer.parseInt(input);
        if(bridgeSize < BRIDGE_SIZE_LOWER_INCLUSIVE || BRIDGE_SIZE_LOWER_INCLUSIVE > BRIDGE_SIZE_UPPER_INCLUSIVE){
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
