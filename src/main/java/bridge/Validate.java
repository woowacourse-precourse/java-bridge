package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.Error.*;

public class Validate {

    private static void isInteger(String inputBridgeSize) {
        String pattern = "^[0-9]*$";
        if(!Pattern.matches(pattern, inputBridgeSize)) {
            throw new IllegalArgumentException(SIZE_INTEGER_ERROR.getMessage());
        }
    }

    private static void isValidRange(String inputBridgeSize) {
        int size = Integer.parseInt(inputBridgeSize);
        if(!(3 <= size && size <= 20 )) {
            throw new IllegalArgumentException(SIZE_RANGE_ERROR.getMessage());
        }
    }

    public static void isInputBridgeSizeValid(String inputBridgeSize) {
        isInteger(inputBridgeSize);
        isValidRange(inputBridgeSize);
    }

    public static void isUOrD(String upOrDown) {
        String pattern = "^[uUdD]$";
        if(!Pattern.matches(pattern, upOrDown)) {
            throw new IllegalArgumentException(NOT_U_OR_D.getMessage());
        }
    }
    public static void isROrQ(String upOrDown) {
        String pattern = "^[rRqQ]$";
        if(!Pattern.matches(pattern, upOrDown)) {
            throw new IllegalArgumentException(NOT_R_OR_Q.getMessage());
        }
    }

    /**
     * DO DX UO UX 이런식으로 들어온다.
     * */
    public static String isUp(String states) {
        if(states.charAt(0) == 'U') {
            return states.substring(1);
        }
        return " ";
    }
    public static String isDown(String states) {
        if(states.charAt(0) == 'D') {
            return states.substring(1);
        }
        return " ";
    }
}
