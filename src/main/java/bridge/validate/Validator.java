package bridge.validate;

public class Validator {

    public static void validateMove(String input) {
        if (!input.equals("D") && !input.equals("U")) {
            throw new IllegalArgumentException("[ERROR] D와 U만 입력하실 수 있습니다.");
        }
    }

    public static boolean validateRetry(String input) {
        if (!input.equals("Q") && !input.equals("R")) {
            throw new IllegalArgumentException("[ERROR] Q와 D만 입력하실 수 있습니다.");
        }
        if (input.equals("R")) {
            return true;
        }
        return false;
    }

    public static void validateSizeRange(int size) {
        if (size <3 || size>20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void validateAlphabet(String input) {
        if (!input.chars().allMatch(Character::isAlphabetic)) {
            throw new IllegalArgumentException("[ERROR] 알파벳을 입력해 주세요.");
        }
        validateBlank(input);
    }

    public static void validateDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 칸은 입력할 수 없습니다.");
        }
    }
}
