package bridge;

import java.util.Objects;

public class Validate {

    public static int validateLengthOfBridge(String lengthOfBridge) {
        validateIsDigit(lengthOfBridge);
        return validateRangeOfLength(lengthOfBridge);
    }

    private static void validateIsDigit(String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }

    private static int validateRangeOfLength(String number) {
        int lengthOfBridge = Integer.parseInt(number);
        if (lengthOfBridge > 20 || lengthOfBridge < 3) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 3이상 20이하여야 합니다.");
        }
        return lengthOfBridge;
    }

    public static String validateMoving(String move) {
        if (!(Objects.equals(move, "U") || Objects.equals(move, "D"))) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 U 또는 D여야 합니다.");
        }
        return move;
    }


}
