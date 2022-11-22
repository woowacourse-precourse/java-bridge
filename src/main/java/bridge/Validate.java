package bridge;

import java.util.regex.Pattern;

import static bridge.Enums.Error.*;
import static bridge.Enums.IntegerValue.*;
import static bridge.Enums.StringValue.*;

public class Validate {

    private static final String CHECK_INTEGER = "^[0-9]*$";
    private static final String CHECK_UP_OR_DOWN = "^[uUdD]$";
    private static final String CHECK_RETRY_OR_QUIT = "^[rRqQ]$";
    private static final String SPACE = " ";
    private static final String UP = "U";
    private static final String DOWN = "D";

    private static void isInteger(String inputBridgeSize) {
        if(!Pattern.matches(CHECK_INTEGER, inputBridgeSize)) {
            throw new IllegalArgumentException(SIZE_INTEGER_ERROR.getMessage());
        }
    }

    private static void isValidRange(String inputBridgeSize) {
        int size = Integer.parseInt(inputBridgeSize);
        if(!(MIN_VALUE.getIntegerValue() <= size && size <= MAX_VALUE.getIntegerValue() )) {
            throw new IllegalArgumentException(SIZE_RANGE_ERROR.getMessage());
        }
    }

    public static void isInputBridgeSizeValid(final String inputBridgeSize) {
        isInteger(inputBridgeSize);
        isValidRange(inputBridgeSize);
    }

    public static void isUOrD(final String upOrDown) {
        if(!Pattern.matches(CHECK_UP_OR_DOWN, upOrDown)) {
            throw new IllegalArgumentException(NOT_U_OR_D.getMessage());
        }
    }
    public static void isROrQ(final String upOrDown) {
        if(!Pattern.matches(CHECK_RETRY_OR_QUIT, upOrDown)) {
            throw new IllegalArgumentException(NOT_R_OR_Q.getMessage());
        }
    }

    /**
     * U 또는 D만 들어온다.
     * */
    public static String isUp(final String states) {
        if(states.equals(UP)) {
            return O.getValue();
        }
        return SPACE;
    }
    public static String isDown(final String states) {
        if(states.equals(DOWN)) {
            return O.getValue();
        }
        return SPACE;
    }
}
