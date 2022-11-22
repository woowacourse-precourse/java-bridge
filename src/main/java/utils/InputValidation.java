package utils;

import static utils.Constant.*;

import java.util.Objects;

public class InputValidation {

    public static void validateBridgeSize (String bridgeSize){
        try{
            int size = Integer.parseInt(bridgeSize);
            if (size < 3 || size >20) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_BRIDGE_SIZE_RANGE.getErrorMessage());
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INT_INPUT_TYPE.getErrorMessage());
        };

    }
    public static void validateMovement (String movement){
        if(!Objects.equals(movement, UP) && !Objects.equals(movement, DOWN)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_ANSWER_INPUT.getErrorMessage());
        }
    }

    public static void validateRestartCommand (String restartCommand){
        if(!Objects.equals(restartCommand, RESTART) && !Objects.equals(restartCommand, QUIT)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_GAME_RESTART_INPUT.getErrorMessage());
        }
    }
}

