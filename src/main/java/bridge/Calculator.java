package bridge;

public class Calculator {
    private static final String WORD_UP = "U";
    private static final String WORD_DOWN = "D";
    private static final String WORD_SPACE = " ";
    private static final String WORD_SUCCESS = "O";
    private static final String WORD_FAIL = "X";

    public static Bridge moveCalculate(String current, String moving) {
        if (!current.equals(moving) && current.equals(WORD_UP))
            return new Bridge(WORD_SPACE, WORD_FAIL);
        if (!current.equals(moving) && current.equals(WORD_DOWN))
            return new Bridge(WORD_FAIL, WORD_SPACE);
        if (current.equals(WORD_UP))
            return new Bridge(WORD_SUCCESS, WORD_SPACE);
        return new Bridge(WORD_SPACE, WORD_SUCCESS);
    }
}
