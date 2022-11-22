package bridge.utils;

import bridge.utils.constants.BridgeGameCommand;
import bridge.utils.constants.BridgeMove;
import bridge.utils.constants.BridgeSize;

import java.util.regex.Pattern;

public class ValidateUtils {

    public static void isCorrectRangeNumbers(String input){
        if(!Pattern.matches(BridgeSize.BRIDGE_SIZE_REGEX, input)){
            throwIllegalArgumentException(BridgeSize.ERROR_BRIDGE_SIZE_MESSAGE);
        }
    }

    public static void isCorrectMoveValue(String input){
        if(!Pattern.matches(BridgeMove.BRIDGE_MOVE_REGEX, input)){
            throwIllegalArgumentException(BridgeMove.ERROR_BRIDGE_MOVE_MESSAGE);
        }
    }

    public static void isCorrectGameCommand(String input){
        if(!Pattern.matches(BridgeGameCommand.GAME_COMMAND_REGEX, input)){
            throwIllegalArgumentException(BridgeGameCommand.ERROR_GAME_COMMAND);
        }
    }

    private static void throwIllegalArgumentException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
