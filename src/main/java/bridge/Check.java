package bridge;

import bridge.exception.BridgeLengthOutOfRange;
import bridge.exception.MoveValid;
import bridge.exception.NotNumeric;

import static bridge.Utility.*;

public class Check {
    public static boolean checkNumeric(String input){
        try{
            Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            IllegalArgumentException exception = new NotNumeric(ERROR_MESSAGE+NOT_NUMERIC_ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }

    public static boolean checkBridgeLengthOutOfRange(int bridgeLength){
        if(!(bridgeLength>=MIN_BRIDGE_LENGTH && bridgeLength<=MAX_BRIDGE_LENGTH)){
            IllegalArgumentException exception = new BridgeLengthOutOfRange(ERROR_MESSAGE+BRIDGE_LENGTH_OUT_OF_RANGE_ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }

    public static boolean checkMoveValid(String input){
        if(!(input.equals(Move.UP.getMoveType()) || input.equals(Move.DOWN.getMoveType()))){
            IllegalArgumentException exception = new MoveValid(ERROR_MESSAGE+MOVE_VALID_ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }

    public static boolean checkReGameOrNotValid(String input){
        if(!(input.equals(REGAME) || input.equals(QUIT))){
            IllegalArgumentException exception = new MoveValid(ERROR_MESSAGE+REGAME_OR_NOT_VALID_ERROR_MESSAGE);
            System.out.println(exception);
            return false;
        }
        return true;
    }
}
