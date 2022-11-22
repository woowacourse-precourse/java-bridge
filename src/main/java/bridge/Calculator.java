package bridge;

public class Calculator {
    private static final String WORD_UP = WordCollection.WORD_UP.getWord();
    private static final String WORD_DOWN = WordCollection.WORD_DOWN.getWord();
    private static final String WORD_SPACE = " ";
    private static final String WORD_SUCCESS = WordCollection.WORD_SUCCESS.getWord();
    private static final String WORD_FAIL = WordCollection.WORD_FAIL.getWord();

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
