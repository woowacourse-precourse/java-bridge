package bridge.util;

public class Validation {

    public static int BRIDGE = 1;
    public static int MOVE = 2;
    public static int RETRY = 3;

    private Validation() {
    }

    public static void test(String input, int type) {
        if (type == BRIDGE)
            isValidBridge(input);
        if (type == MOVE)
            isValidMoving(input);
        if (type == RETRY)
            isValidRetry(input);
    }

    private static void assertError(String msg) {
        throw new IllegalArgumentException("[ERROR] " + msg);
    }

    private static void isValidMoving(String input) {
        if (!input.equals("U") & !input.equals("D")) {
            assertError("잘못된 문자열입니다. U/D 중에 하나를 입력해 주세요");
        }
    }

    private static void isValidRetry(String input) {
        if (!input.equals("R") & !input.equals("Q")) {
            assertError("잘못된 문자열입니다. R/Q 중에 하나를 입력해 주세요");
        }
    }

    private static void isValidBridge(String input) {
        if (!isDigits(input)) {
            assertError("숫자를 입력해주세요");
        }
        if (!isValidRange(input)) {
            assertError("3이상 20이하의 자연수를 입력해 주세요");
        }
    }

    private static boolean isDigits(String input) {
        return !input.equals("") & input.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidRange(String input) {
        return Integer.parseInt(input) >= 3 & Integer.parseInt(input)<=20;
    }

}
