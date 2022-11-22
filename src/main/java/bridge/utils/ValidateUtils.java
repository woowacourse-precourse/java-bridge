package bridge.utils;

import bridge.utils.constants.BridgeGameRegex;

import bridge.utils.constants.ErrorMessage;
import java.util.regex.Pattern;

public class ValidateUtils {

    public static void isCorrectRangeNumbers(String input){
        if(!Pattern.matches(BridgeGameRegex.BRIDGE_SIZE_INPUT_REGEX.getRegex(), input)){
            throwIllegalArgumentException(ErrorMessage.ERROR_BRIDGE_SIZE_MESSAGE.getMessage());
        }
    }

    public static void isCorrectMoveValue(String input){
        if(!Pattern.matches(BridgeGameRegex.BRIDGE_MOVE_INPUT_REGEX.getRegex(), input)){
            throwIllegalArgumentException(ErrorMessage.ERROR_BRIDGE_MOVE_MESSAGE.getMessage());
        }
    }

    public static void isCorrectGameCommand(String input){
        if(!Pattern.matches(BridgeGameRegex.GAME_RETRY_COMMAND_REGEX.getRegex(), input)){
            throwIllegalArgumentException(ErrorMessage.ERROR_GAME_COMMAND.getMessage());
        }
    }

    private static void throwIllegalArgumentException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
