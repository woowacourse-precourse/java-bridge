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

    public static void validateMove(String input){
        if (!input.equals("U") && !input.equals("D"))
            throw new IllegalArgumentException(BridgeException.INVALID_MOVE.getErrorMessage());
    }

    public static void validateRestartStatus(String input){
        if (!input.equals("R") && !input.equals("Q"))
            throw new IllegalArgumentException(BridgeException.INVALID_RESTART_STATUS.getErrorMessage());
    }

    public static boolean movingResult(String input, String result){
        if(input.equals(result))
            return true;
        if(!input.equals(result))
            return false;

        throw new IllegalArgumentException(BridgeException.INVALID_MOVE.getErrorMessage());
    }

}
