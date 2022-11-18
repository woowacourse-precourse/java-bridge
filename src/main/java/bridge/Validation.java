package bridge;

public class Validation {
    static final int BRIDGE_SIZE_MINIMUM_INCLUSIVE = 3;
    static final int BRIDGE_SIZE_MAXIMUM_INCLUSIVE = 20;

    public static void validateBridgeSize(String userInput) {
        validateBridgeSizeIsNumber(userInput);
        validateBridgeSizeOutOfRange(userInput);
    }

    private static void validateBridgeSizeIsNumber(String userInput) {
        if (!userInput.matches("\\d+")) {
            System.out.println("[ERROR] 다리 길이는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateBridgeSizeOutOfRange(String userInput) {
        int bridgeSize = Integer.parseInt(userInput);

        if (bridgeSize < BRIDGE_SIZE_MINIMUM_INCLUSIVE || bridgeSize > BRIDGE_SIZE_MAXIMUM_INCLUSIVE) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateMovingChoice(String userInput) {
        if (!userInput.matches("[UD]")) {
            System.out.println("[ERROR] U 또는 D만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }
}
