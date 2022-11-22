package bridge.validation;

import bridge.validation.enumeration.Mode;

public class Validation {
    private static final String IS_NUMBER = "[0-9]+";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_A_NUMBER = "숫자가 아닙니다.";
    private static final String OUT_OF_RANGE = "범위를 넘어섰습니다.";
    private static final String NO_INPUT = "입력이 없습니다.";
    private static final String NOT_CORRECT_CHARACTER = "올바른 문자가 아닙니다.";

    public static void verifyUserInputBridgeLength(String input){
        verifyUserInputIsEmpty(input.length());
        verifyUserInputIsNumber(input);
        verifyUserInputIsInScope(Integer.parseInt(input));
    }

    private static void verifyUserInputIsNumber(String input) {
        if(!input.matches(IS_NUMBER)) errorThrow(NOT_A_NUMBER);
    }

    private static void verifyUserInputIsInScope(int input) {
        if(!(input >= 3 && input <= 20)) errorThrow(OUT_OF_RANGE);
    }

    private static void verifyUserInputIsEmpty(int length) {
        if(length == 0) errorThrow(NO_INPUT);
    }

    public static void verifyUserInputIsCharacter(String input, Mode mode){
        verifyUserInputIsEmpty(input.length());
        verifyUserInputIsCommand(input, mode);
    }

    private static void verifyUserInputIsCommand(String input, Mode mode) {
        if(mode == Mode.UpOrDown) verifyUpOrDown(input, mode);
        if(mode == Mode.RetryOrQuit) verifyRetryOrQuit(input, mode);
    }

    private static void verifyUpOrDown(String input, Mode mode) {
        if(!(mode == Mode.UpOrDown && (input.equals(UP) || input.equals(DOWN)))){
            errorThrow(NOT_CORRECT_CHARACTER);
        }
    }

    private static void verifyRetryOrQuit(String input, Mode mode) {
        if(!(mode == Mode.RetryOrQuit && (input.equals(RETRY) || input.equals(QUIT)))){
            errorThrow(NOT_CORRECT_CHARACTER);
        }
    }

    private static void errorThrow (String errorMessage){
        throw new IllegalArgumentException(ERROR + errorMessage);
    }
}
