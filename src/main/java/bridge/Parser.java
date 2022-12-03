package bridge;

import bridge.constant.ErrorMessage;

public class Parser {

    public static Integer parseToInt(String input) {
        Integer toInt;
        try {
            toInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_IS_INCORRECT.getMessage());
        }
        return toInt;
    }
}
