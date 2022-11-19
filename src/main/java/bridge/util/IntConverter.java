package bridge.util;

public class IntConverter {

    private static final String EXCEPTION_MESSAGE_NO_NUMBER = "[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";

    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NO_NUMBER);
        }
    }
}
