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
}
