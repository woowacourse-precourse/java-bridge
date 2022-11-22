package bridge.validator;

import java.util.regex.Pattern;

import static bridge.exception.InputException.*;

public class InputValidator {
    private static final Pattern BLOCK_FORMAT = Pattern.compile("^[UD]$");
    private static final Pattern GAME_RETRY_FORMAT = Pattern.compile("^[RQ]$");
    private static final int BLOCK_LENGTH = 1;


    private InputValidator() {
    }

    public static String checkBlock(String block) {
        validateOneLength(block);
        validateInputFormat(block, BLOCK_FORMAT);
        return block;
    }

    public static String checkGameRetry(String input) {
        validateOneLength(input);
        validateInputFormat(input, GAME_RETRY_FORMAT);
        return input;
    }

    private static void validateOneLength(String input) {
        if (input.length() != BLOCK_LENGTH) {
            printNotOnlyOneLengthException();
        }
    }

    private static void validateInputFormat(String block, Pattern format) {
        if (!format.matcher(block).matches()) {
            printNotFormatException();
        }
    }
}
