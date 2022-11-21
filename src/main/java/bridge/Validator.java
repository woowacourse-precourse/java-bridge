package bridge;

import static bridge.ErrorGenerator.*;

public class Validator {
    private static final int BRIDGE_LEN_LOWER_BOUND=3;
    private static final int BRIDGE_LEN_HIGHER_BOUND=20;
    private static final int BRIDGE_RANDOM_NUMBER_ZERO= 0;
    private static final int BRIDGE_RANDOM_NUMBER_ONE=1;
    private static final char MOVING_UP='U';
    private static final char MOVING_DOWN='D';
    private static final char GAME_RESTART='R';
    private static final char GAME_QUIT='Q';
    private static final int MOVING_INPUT_LENGTH=1;
    private static final int GAME_CHECK_LENGTH=1;

    public static void validateBridgeRandomNum(int num){
        if (num != BRIDGE_RANDOM_NUMBER_ZERO || num != BRIDGE_RANDOM_NUMBER_ONE)
            ErrorGenerator.errorGenerate("다리 생성 랜덤 숫자가 0또는 1이 아닙니다");
    }
    public static void validateNumber(String str){
        try
        {
            int number= Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            ErrorGenerator.errorGenerate("숫자 포맷이 아닙니다.");
        }
    }

    public static void validateBridgeLength(String str){
        validateNumber(str);
        int num = Integer.parseInt(str);
        if (num < BRIDGE_LEN_LOWER_BOUND || num > BRIDGE_LEN_HIGHER_BOUND)
            ErrorGenerator.errorGenerate("다리 길이가 3이상 20이하가 아닙니다");
    }

    public static void validateMovingLen (String str) {
        if (str.length()!= MOVING_INPUT_LENGTH)
            ErrorGenerator.errorGenerate("이동한 칸 입력 길이가 1이 아닙니다");
    }
    public static void validateMoving(String str){
        validateMovingLen(str);
        char bridgeChoose = str.charAt(0);
        if (bridgeChoose!= MOVING_UP || bridgeChoose != MOVING_DOWN)
            ErrorGenerator.errorGenerate("이동할 칸이 위 또는 아래가 아닙니다");
    }

    public static void validateGameCheckInputLen (String str) {
        if (str.length()!= GAME_CHECK_LENGTH)
            ErrorGenerator.errorGenerate("게임 재시작 또는 종료 키 길이가 1이 아닙니다");
    }
    public static void validateGameCheck(String str){
        validateGameCheckInputLen(str);
        char gameCheck = str.charAt(0);
        if (gameCheck != GAME_RESTART || gameCheck != GAME_QUIT)
            ErrorGenerator.errorGenerate("게임 재시작 또는 종료 키가 아닙니다");
    }

}
