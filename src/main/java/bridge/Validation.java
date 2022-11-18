package bridge;

public class Validation {
    private static void validateBridgeSizeIsNumber(String userInput) {
        if (userInput.matches("\\D+")) {
            System.out.println("[ERROR] 다리 길이는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
