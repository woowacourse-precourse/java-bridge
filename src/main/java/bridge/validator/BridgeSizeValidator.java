package bridge.validator;

public class BridgeSizeValidator {
    public static void validate(String input) {
        validateNumber(input);
    }

    public static void validate(int size){
        validateRange(size);
    }

    private static void validateNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            System.out.println("[ERROR] 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(int size) {
        if (size < 3 || size > 20) {
            System.out.println("[ERROR] 범위는 3 이상 20 이하여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
