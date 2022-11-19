package bridge;

public class BridgeException {

    public static int BridgeSizeException(String input) {
        if (!input.matches("[+-]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20 이하 숫자를 입력해주시오.");
        }
        return size;
    }

    public static String MovingException(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] U, D 중에서 하나의 문자를 입력하시오.");
        }
        if (input.charAt(0) != 'U' && input.charAt(0) != 'D') {
            throw new IllegalArgumentException("[ERROR] U, D 중에서 하나의 문자를 입력하시오.");
        }
        return input;
    }

    public static String GameCommandException(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] R, Q 중에서 하나의 문자를 입력하시오.");
        }
        if (input.charAt(0) != 'R' && input.charAt(0) != 'Q') {
            throw new IllegalArgumentException("[ERROR] R, Q 중에서 하나의 문자를 입력하시오.");
        }
        return input;
    }
}
