package bridge.Validator;

public class InputValidator {
    public static void validateNumeric(String input) {
        boolean isNumeric = isNumeric(input);
        if (!isNumeric) {
            String ERROR_FOR_LENGTH_OF_BRIDGE = "[ERROR] 다리의 길이는 3이상 20이하의 숫자만 가능합니다.";
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public static void validateRange(int input) {
        if (input < 3 || input > 20) {
            String ERROR_FOR_LENGTH_OF_BRIDGE = "[ERROR] 다리의 길이는 3이상 20이하의 숫자만 가능합니다.";
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static void validateUpOrDown(String input) {
        String UP = "U";
        String DOWN = "D";
        if (!(input.equals(UP) || input.equals(DOWN))) {
            String ERROR_FOR_UP_OR_DOWN = "[ERROR] 위: \"U\", 아래: \"D\"로만 가능합니다.";
            throw new IllegalArgumentException(ERROR_FOR_UP_OR_DOWN);
        }
    }

    public static void validateRetry(String input) {
        String RETRY = "R";
        String QUIT = "Q";
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            String ERROR_FOR_RETRY_OR_QUIT = "[ERROR] 재시도: \"R\", 종료: \"Q\"로만 가능합니다";
            throw new IllegalArgumentException(ERROR_FOR_RETRY_OR_QUIT);
        }
    }
}
