package bridge.service;

import bridge.exception.BridgeException;

public class BridgeService {

    public static int validateBridgeLength(String input){
        int intInput = validateNumeric(input);

        if (intInput > 20 || intInput < 3)
            throw new IllegalArgumentException(BridgeException.INVALID_LENGTH_RANGE.getErrorMessage());

        return intInput;
    }

    private static int validateNumeric(String input){
        try{
            return Integer.parseInt(input);
        }catch(Exception exception){
            throw new IllegalArgumentException(BridgeException.NOT_NUMERIC.getErrorMessage());
        }
    }
}
