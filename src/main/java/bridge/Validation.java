package bridge;

public class Validation {
    static final int BRIDGE_SIZE_MINIMUM_INCLUSIVE = 3;
    static final int BRIDGE_SIZE_MAXIMUM_INCLUSIVE = 20;

    private static void validateBridgeSizeIsNumber(String userInput) {
        if (userInput.matches("\\D+")) {
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
}
