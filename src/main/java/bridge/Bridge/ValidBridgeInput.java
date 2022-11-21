package bridge.Bridge;

import bridge.Enums.Error;

public class ValidBridgeInput {
    private static int MIN_BRIDGE_SIZE = 3;
    private static int MAX_BRIDGE_SIZE = 20;

    // 다리 길이 validation (숫자인지)
    public static void checkBridgeSizeNumeric(String length){
        try{
            Integer.parseInt(length);
        }
        catch(IllegalArgumentException e){
            Error.NOT_NUMERIC_ERROR.error();
        }
    }

    public static void checkBridgeSizeValid(String length){
        if(Integer.parseInt(length) < MIN_BRIDGE_SIZE 
                || Integer.parseInt(length) > MAX_BRIDGE_SIZE ){
            Error.BRIDGE_LEN_ERROR.error();
        }
    }
}
