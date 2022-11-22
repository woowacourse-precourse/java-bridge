package bridge.util;

public class ParsingUtils {
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 값을 입력하였습니다.";

    public static int stringToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        return number;
    }
}
