package bridge.validator;

public class BridgeSizeValidator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 30;

    public static void validate(String size) {
        validateDigit(size);
        validateInput(size);
        validateSize(toInt(size));
    }

    private static void validateInput(String size) {
        if (isBlank(size)) {
            throw new NumberFormatException("[ERROR]");
        }
    }

    private static boolean isBlank(String size) {
        return size.trim().equals("");
    }

    private static void validateDigit(String size) {
        if (isDigit(size)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    private static void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private static boolean isDigit(String size) {
        return !size.chars().allMatch(Character::isDigit);
    }

    private static int toInt(String size) {
        return Integer.parseInt(size);
    }
}
