package bridge.Controller;

import bridge.Domain.BridgeRow;
import java.util.regex.Pattern;

public class Validation {
    private static final int BRIDGE_SIZE_RANGE_START = 3;
    private static final int BRIDGE_SIZE_RANGE_END = 20;
    public static final String GAME_RETRY = "R";
    public static final String GAME_QUIT = "Q";
    private static final String REGEX_NUMERIC = "^[0-9]*$";
    private static final String REGEX_ALPHABET = "^[a-zA-Z]*$";
    private static final String ERROR_START_MESSAGE = "[ERROR] ";
    private static final String ERROR_MESSAGE_NOT_ALPHABETIC = "알파벳로 이루어진 입력이 아닙니다.";
    private static final String ERROR_MESSAGE_NOT_NUMERIC = "숫자로 이루어진 입력이 아닙니다.";
    private static final String ERROR_MESSAGE_NOT_IN_RANGE = BRIDGE_SIZE_RANGE_START + "이상, " + BRIDGE_SIZE_RANGE_END + "이하인 숫자 입력이 아닙니다.";
    private static final String ERROR_MESSAGE_INVALID_GAME_COMMAND = "게임 재시작 또는 종료 시, 조건에 맞지 않는 입력입니다. (" + Validation.GAME_RETRY + " 또는 " + Validation.GAME_QUIT + " 이어야 합니다.)";
    private static final String ERROR_MESSAGE_INVALID_GAME_MOVING = "다리 건너기를 위한 올바른 입력이 아닙니다.";

    public static void validateBridgeSize(String bridgeSize){
        validateInputIsNumeric(bridgeSize);
        validateInputIsInRange(bridgeSize);
    }
    public static void validateMoving(String moving){
        validateInputIsAlphabetic(moving);
        validateInputIsValidMoving(moving);
    }
    public static void validateGameCommand(String gameCommand){
        validateInputIsAlphabetic(gameCommand);
        validateInputIsValidGameCommand(gameCommand);
    }

    public static void validateInputIsNumeric(String input){
        if(!Pattern.matches(REGEX_NUMERIC, input)){
            throw new IllegalArgumentException(ERROR_START_MESSAGE + ERROR_MESSAGE_NOT_NUMERIC);
        }
    }
    public static void validateInputIsInRange(String input){
        int num = Integer.parseInt(input);
        if(num < BRIDGE_SIZE_RANGE_START || num > BRIDGE_SIZE_RANGE_END){
            throw new IllegalArgumentException(ERROR_START_MESSAGE + ERROR_MESSAGE_NOT_IN_RANGE);
        }
    }

    public static void validateInputIsAlphabetic(String input){
        if(!Pattern.matches(REGEX_ALPHABET, input)){
            throw new IllegalArgumentException(ERROR_START_MESSAGE + ERROR_MESSAGE_NOT_ALPHABETIC);
        }
    }

    public static void validateInputIsValidMoving(String input){
        if(!BridgeRow.getRowNames().contains(input)){
            throw new IllegalArgumentException(ERROR_START_MESSAGE + ERROR_MESSAGE_INVALID_GAME_MOVING);
        }
    }

    public static void validateInputIsValidGameCommand(String input){
        if(!input.equals(GAME_RETRY) && !input.equals(GAME_QUIT)){
            throw new IllegalArgumentException(ERROR_START_MESSAGE + ERROR_MESSAGE_INVALID_GAME_COMMAND);
        }
    }
}
