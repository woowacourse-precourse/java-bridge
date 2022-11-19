package bridge.views;

import bridge.utils.Setting;

public class Validator {

    public static int validateBridgeSize(String input) {
        int number = isNumber(input);
        inValidRange(number);
        return number;
    }

    private static int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void inValidRange(int number) {
        if (number < Setting.BRIDGE_SIZE_LOWER_BOUND || number > Setting.BRIDGE_SIZE_UPPER_BOUND) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 다리 길이는 %d부터 %d사이의 숫자여야 합니다.",
                            Setting.BRIDGE_SIZE_LOWER_BOUND, Setting.BRIDGE_SIZE_UPPER_BOUND));
        }
    }

    public static void isUOrD(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] (위: U, 아래: D) 두 영어 대문자 중 하나를 입력해주세요.");
        }
    }

    public static void isROrQ(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] (재시도: R, 종료: Q) 두 영어 대문자 중 하나를 입력해주세요.");
        }
    }
}
