package bridge;


import java.util.Objects;

public class ErrorControl {
    public static int validateNumberOrNot(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new MyIllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 | bridgeSize > 20) {
            throw new MyIllegalArgumentException("[Error] 3이상 20이하의 숫자를 입력해 주세요.");
        }
    }

    public static void validateLetter(String input, String verifier1, String verifier2) {
        if (!(Objects.equals(input, verifier1) | Objects.equals(input, verifier2))) {
            throw new MyIllegalArgumentException("[ERROR] " + verifier1 + "," + verifier2 + " 중 하나를 입력해 주세요.");
        }
    }
}
