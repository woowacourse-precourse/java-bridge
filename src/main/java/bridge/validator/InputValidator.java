package bridge.validator;

import java.util.regex.Pattern;

public class InputValidator {

    public static void validateBridgeSize(String input) throws IllegalArgumentException {
        String condition = "^[0-9]+$";

        if (!Pattern.matches(condition, input)) {
            System.out.println("[ERROR] 다리의 길이는 3에서 20 사이의 정수입니다.");
            throw new IllegalArgumentException();
        }
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            System.out.println("[ERROR] 다리의 길이는 3에서 20 사이의 정수입니다.");
            throw new IllegalArgumentException();
        }
    }
}
