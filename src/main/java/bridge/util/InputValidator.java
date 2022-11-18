package bridge.util;

public class InputValidator {

    private static final int ANSWER_SIZE = 1;
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String UP = "U";
    private static final String DOWN = "D";

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
