package bridge;

public class Validation {
    private static final int NUMBER_MIN = ValueCollection.VALUE_MIN.getValue();
    private static final int NUMBER_MAX = ValueCollection.VALUE_MAX.getValue();
    private static final String NUMBER_REMOVE_REGEX = "[0-9]";
    private static final String REGEX_CHANGE_WORD = "";
    private static final String WORD_UP = WordCollection.WORD_UP.getWord();
    private static final String WORD_DOWN = WordCollection.WORD_DOWN.getWord();
    private static final String WORD_RESTART = WordCollection.WORD_RESTART.getWord();
    private static final String WORD_QUIT = WordCollection.WORD_QUIT.getWord();

    public static void isInputIncludeCharacter(String input) {
        String result = input.replaceAll(NUMBER_REMOVE_REGEX, REGEX_CHANGE_WORD);
        if (result.length() != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_INCLUDE_CHARACTER.getMessage());
    }

    public static void isInputBetweenMinAndMax(int input) {
        if (input < NUMBER_MIN || input > NUMBER_MAX)
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_NOT_BETWEEN_MIN_AND_MAX.getMessage());
    }

    public static void isInputUpOrDown(String input) {
        if (!input.equals(WORD_UP) && !input.equals(WORD_DOWN))
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_UP_OR_DOWN.getMessage());
    }

    public static void isInputRestartOrQuit(String input) {
        if (!input.equals(WORD_RESTART) && !input.equals(WORD_QUIT))
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_RESTART_OR_QUIT.getMessage());
    }
}