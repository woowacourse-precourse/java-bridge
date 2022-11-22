package bridge.exception;

import static bridge.domain.BridgeCommand.*;

public class BridgeException {

    public static int bridgeSizeException(String input) {
        if (!input.matches("[+-]?\\d*\\.?\\d+") || input.length() > 9) {
            throw new IllegalArgumentException("[ERROR] 3이상 20 이하 숫자를 입력해주시오.");
        }
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20 이하 숫자를 입력해주시오.");
        }
        return size;
    }

    public static String movingException(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] U, D 중에서 하나의 문자를 입력하시오.");
        }
        if (!input.equals(UP.getElement()) && !input.equals(DOWN.getElement())) {
            throw new IllegalArgumentException("[ERROR] U, D 중에서 하나의 문자를 입력하시오.");
        }
        return input;
    }

    public String gameCommandException(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] R, Q 중에서 하나의 문자를 입력하시오.");
        }
        if (!input.equals(RETRY.getElement()) && !input.equals(QUIT.getElement())) {
            throw new IllegalArgumentException("[ERROR] R, Q 중에서 하나의 문자를 입력하시오.");
        }
        return input;
    }
}
