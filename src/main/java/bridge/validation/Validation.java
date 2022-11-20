package bridge.validation;

import bridge.validation.enumeration.Mode;

public class Validation {
    private static final String IS_NUMBER = "[0-9]+";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    // 사용자 입력이 올바른지 확인 - 숫자인지
    public static void verifyUserInputBridgeLength(String input){
        verifyUserInputIsEmpty(input.length());
        verifyUserInputIsNumber(input);
        verifyUserInputIsInScope(Integer.parseInt(input));
    }

    private static void verifyUserInputIsNumber(String input) {
        if(!input.matches(IS_NUMBER)) throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
    }

    private static void verifyUserInputIsInScope(int input) {
        if(!(input >= 3 && input <= 20)) throw new IllegalArgumentException("[ERROR]범위를 넘어섰습니다.");
    }

    private static void verifyUserInputIsEmpty(int length) {
        if(length == 0) throw new IllegalArgumentException("[ERROR] 입력이 없습니다.");
    }

    // 사용자 입력이 올바른지 확인 - 문자 하나
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
            throw new IllegalArgumentException("[ERROR] 올바른 문자를 입력해주세요.");
        }
    }

    private static void verifyRetryOrQuit(String input, Mode mode) {
        if(!(mode == Mode.RetryOrQuit && (input.equals(RETRY) || input.equals(QUIT)))){
            throw new IllegalArgumentException("[ERROR] 올바른 문자를 입력해주세요.");
        }
    }
}
