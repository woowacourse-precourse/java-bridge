package bridge;

import java.util.regex.Pattern;

public class Validate {
    private final static String NUMERIC_PATTERN = "^[0-9]*$";
    private final static String UP_OR_DOWN_PATTERN = "^[UD]*$";
    private final static int MAX_BRIDGE_SIZE = 20;
    private final static int MIN_BRIDGE_SIZE = 3;

    private boolean isNumeric(String input) {
        return Pattern.matches(NUMERIC_PATTERN, input);
    }

    private boolean isBridgeSizeRange(String input) {
        if (isNumeric(input)){
            return (MIN_BRIDGE_SIZE <= Integer.parseInt(input)
                    && Integer.parseInt(input) <= MAX_BRIDGE_SIZE);
        }
        return false;
    }

    public void isBridgeSize(String input){
        if (!isBridgeSizeRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isUpOrDown(String input) {
        return Pattern.matches(UP_OR_DOWN_PATTERN, input);
    }

    public void isMoving(String input) {
        if (!isUpOrDown(input)){
            throw new IllegalArgumentException();
        }
    }
}
