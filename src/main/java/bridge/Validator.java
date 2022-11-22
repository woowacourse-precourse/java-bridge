package bridge;

import java.util.regex.Pattern;

import static bridge.GameMessage.ERROR_MESSAGE;


public class Validator {
    private static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;

    public static void validateBridgeInput(String input){
        validateNumeric(input);
        validateBridgeSize(input);
    }

    public static void validateMoveInput(String input){
        String movePattern = "[UD]";
        if(!Pattern.matches(movePattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "이동 형태는 U또는 D여야 합니다");
        }
    }
    public static void validateRestartInput(String input){
        String restartPattern = "[RQ]";
        if(!Pattern.matches(restartPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "재시도 여부는 R 또는 Q여야 합니다");
        }
    }


    public static void validateNumeric(String input){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 형태가 아닙니다");
        }
    }

    public static void validateBridgeSize(String input){
        int bridgeSize = Integer.parseInt(input);
        if(bridgeSize < BRIDGE_SIZE_LOWER_INCLUSIVE || BRIDGE_SIZE_LOWER_INCLUSIVE > BRIDGE_SIZE_UPPER_INCLUSIVE){
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

}
