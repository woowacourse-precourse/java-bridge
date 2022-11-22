package bridge.controller.util;

public class MessageConverter {

    private static final String FORMAT_ERROR_MESSAGE = "숫자인 문자여야 합니다";

    public static final Integer convertStringTOInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }
}
