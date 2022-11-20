package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Validate {

    private static void isInteger(String inputBridgeSize) {
        String pattern = "^[0-9]*$";
        if(!Pattern.matches(pattern, inputBridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
    }

    private static void isValidRange(String inputBridgeSize) {
        int size = Integer.parseInt(inputBridgeSize);
        if(!(3 <= size && size <= 20 )) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void isInputBridgeSizeValid(String inputBridgeSize) {
        isInteger(inputBridgeSize);
        isValidRange(inputBridgeSize);
    }

    public static void isUOrD(String upOrDown) {
        String pattern = "^[uUdD]$";
        if(!Pattern.matches(pattern, upOrDown)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 가능합니다.(소문자도 가능)");
        }
    }
    public static void isROrQ(String upOrDown) {
        String pattern = "^[rRqQ]$";
        if(!Pattern.matches(pattern, upOrDown)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 가능합니다.(소문자도 가능)");
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
