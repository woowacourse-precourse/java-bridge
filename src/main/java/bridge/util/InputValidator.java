package bridge.util;

public class InputValidator {

    private static final int ANSWER_SIZE = 1;
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static boolean checkUserAnswer(String answer) {
        return isSizeValid(answer) && isComponentValid(answer);
    }

    public static boolean isSizeValid(String answer) {
        return answer.length() == ANSWER_SIZE;
    }

    public static boolean isComponentValid(String answer) {
        return answer.equals(RETRY) || answer.equals(QUIT);
    }
}
