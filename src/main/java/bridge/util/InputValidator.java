package bridge.util;

public class InputValidator {

    private static final int ANSWER_SIZE = 1;
    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String UP = "U";
    private static final String DOWN = "D";

    public static boolean checkBridgeValid(String answer) {
        return !isBlank(answer) && isInteger(answer) && isBridgeLengthValid(answer);
    }

    public static boolean isBlank(String answer) {
        return answer.isBlank();
    }

    public static boolean isInteger(String answer) {
        return answer.chars().allMatch(Character::isDigit);
    }

    public static boolean isBridgeLengthValid(String answer) {
        int length = Integer.parseInt(answer);
        return length >= MINIMUM_BRIDGE_LENGTH && length <= MAXIMUM_BRIDGE_LENGTH;
    }

    public static boolean checkRetryOrQuitValid(String answer) {
        return isSizeValid(answer) && isRetryOrQuitComponentValid(answer);
    }

    public static boolean isSizeValid(String answer) {
        return answer.length() == ANSWER_SIZE;
    }

    public static boolean isRetryOrQuitComponentValid(String answer) {
        return answer.equals(RETRY) || answer.equals(QUIT);
    }

    public static boolean checkUpAndDownValid(String answer) {
        return isSizeValid(answer) && isUpAndDownComponentValid(answer);
    }

    public static boolean isUpAndDownComponentValid(String answer) {
        return answer.equals(UP) || answer.equals(DOWN);
    }
}
