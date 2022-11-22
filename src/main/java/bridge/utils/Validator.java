package bridge.utils;

public class Validator {
    public static final String NOT_NUMBER_EXCEPTION = "숫자를 입력해주세요.";
    public static final String INVALID_RANGE_EXCEPTION = "다리 길이는 3부터 20사이의 숫자여야 합니다.";
    public static final String INVALID_UP_OR_DOWN_EXCEPTION = "(위: U, 아래: D) 두 영어 대문자 중 하나를 입력해주세요.";
    public static final String INVALID_RESTART_OR_QUIT_EXCEPTION = "(재시도: R, 종료: Q) 두 영어 대문자 중 하나를 입력해주세요.";

    public static void validateBridgeSize(String input) {
        int number = isNumber(input);
        inValidRange(number);
    }

    private static int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }

    private static void inValidRange(int number) {
        if (number < Setting.BRIDGE_SIZE_LOWER_BOUND || number > Setting.BRIDGE_SIZE_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_RANGE_EXCEPTION);
        }
    }

    public static void isUOrD(String input) {
        if (!(input.equals(Setting.UPPER_BRIDGE) || input.equals(Setting.LOWER_BRIDGE))) {
            throw new IllegalArgumentException(INVALID_UP_OR_DOWN_EXCEPTION);
        }
    }

    public static void isROrQ(String input) {
        if (!(input.equals(Setting.GAME_RESTART) || input.equals(Setting.GAME_QUIT))) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_QUIT_EXCEPTION);
        }
    }
}
