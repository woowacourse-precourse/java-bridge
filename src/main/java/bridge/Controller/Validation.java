package bridge.Controller;

import bridge.Domain.BridgeRow;
import java.util.regex.Pattern;

public class Validation {
    public static final String GAME_RETRY = "R";
    public static final String GAME_QUIT = "Q";
    static final String REGEX_NUMERIC = "^[0-9]*$";
    static final String REGEX_ALPHABET = "^[a-zA-Z]*$";
    static final int BRIDGE_SIZE_RANGE_START = 3;
    static final int BRIDGE_SIZE_RANGE_END = 20;

    public static void validateReadBridgeSize(String bridgeSize){
        validateInputIsNumeric(bridgeSize);
        validateInputIsInRange(bridgeSize);
    }
    public static void validateReadMoving(String moving){
        validateInputIsAlphabetic(moving);
        validateInputIsValidMoving(moving);
    }
    public static void validateReadGameCommand(String gameCommand){
        validateInputIsAlphabetic(gameCommand);
        validateGameCommand(gameCommand);
    }

    public static void validateInputIsNumeric(String input){
        if(!Pattern.matches(REGEX_NUMERIC, input)){
            throw new IllegalArgumentException("숫자로 이루어진 입력이 아닙니다.");
        }
    }
    public static void validateInputIsInRange(String input){
        int num = Integer.parseInt(input);
        if(num < BRIDGE_SIZE_RANGE_START || num > BRIDGE_SIZE_RANGE_END){
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_START + "이상, " + BRIDGE_SIZE_RANGE_END + "이하인 숫자 입력이 아닙니다.");
        }
    }

    public static void validateInputIsAlphabetic(String input){
        if(!Pattern.matches(REGEX_ALPHABET, input)){
            throw new IllegalArgumentException("알파벳로 이루어진 입력이 아닙니다.");
        }
    }

    public static void validateInputIsValidMoving(String input){
        if(!BridgeRow.getRowPositions().contains(input)){
            throw new IllegalArgumentException("다리 건너기 게임에서 올바른 입력이 아닙니다.");
        }
    }

    public static void validateGameCommand(String input){
        if(!input.equals(GAME_RETRY) && !input.equals(GAME_QUIT)){
            throw new IllegalArgumentException("게임 재시작 또는 종료 시, 조건에 맞지 않는 입력입니다. (" + Validation.GAME_RETRY + " 또는 " + Validation.GAME_RETRY + " 이어야 합니다.)");
        }
    }
}
