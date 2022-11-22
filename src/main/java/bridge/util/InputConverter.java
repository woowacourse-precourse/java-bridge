package bridge.util;

public class InputConverter {
    private static final String OVERSIZED_INPUT_MSG = "정수 범위를 넘은 입력값입니다.";

    public static int toInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(OVERSIZED_INPUT_MSG);
        }
    }

    private InputConverter() {

    }
}
