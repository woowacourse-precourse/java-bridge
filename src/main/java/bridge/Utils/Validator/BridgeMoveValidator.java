package bridge.Utils.Validator;

import bridge.Utils.Constants.MoveInputAndNextInput;

public class BridgeMoveValidator {

    private static final String UP = "U";


    public static MoveInputAndNextInput compareMoveInputAndNextMove(String moveInput, String nextMove) {
        if(moveInput.equals(nextMove)){
            return getO(moveInput);
        }
        return getX(moveInput);
    }

    public static MoveInputAndNextInput getO(String moveInput){
        if(moveInput.equals(UP)){
            return MoveInputAndNextInput.UP_O;
        }
        return MoveInputAndNextInput.DOWN_O;
    }

    public static MoveInputAndNextInput getX(String moveInput){
        if(moveInput.equals(UP)){
            return MoveInputAndNextInput.UP_X;
        }
        return MoveInputAndNextInput.DOWN_X;
    }

}
