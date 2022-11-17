package bridge;

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
}
